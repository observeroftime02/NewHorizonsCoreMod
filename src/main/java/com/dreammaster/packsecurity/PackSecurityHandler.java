package com.dreammaster.packsecurity;


import com.dreammaster.auxiliary.SHA1Digest;
import com.dreammaster.auxiliary.TripleDES;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.network.msg.PackSecurityHandShake;
import com.dreammaster.packsecurity.containerClasses.ClientAuthorizedState;
import com.dreammaster.packsecurity.containerClasses.PackLoadedModInfo;
import com.dreammaster.packsecurity.containerClasses.PackSecurityModListEntry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;


public class PackSecurityHandler
{
  private HashMap<String, ClientAuthorizedState> _mPendingConnectionSecrets;
  private List<PackSecurityModListEntry> _mModfolderFiles;
  private static final Object modListLock = new Object();
  private static final Object pendingConnectionsLock = new Object();
  public static String SharedSecret = "";

  public PackSecurityHandler()
  {
    _mModfolderFiles = new ArrayList<>();
    _mPendingConnectionSecrets = new HashMap<>();
    try
    {
      SharedSecret = SHA1Digest.calcSHA1( new File( PackSecurityHandShake.class.getProtectionDomain().getCodeSource().getLocation().getPath() ) );
    }
    catch( Exception e )
    {
    }
  }

  public List<PackSecurityModListEntry> getModFilePayload()
  {
    return Collections.unmodifiableList( _mModfolderFiles );
  }

  /**
   * Run through all jar files in the /mods/ folder and generate file hashes
   * This is triggered upon startup, and runs as a separate thread
   */
  public void Init()
  {
    new Thread( new Runnable()
    {
      public void run()
      {
        List<PackSecurityModListEntry> tModfolderFiles = new ArrayList<>();
        String ext[] = { "jar" };
        File file = new File( "./mods/" );
        Collection<File> files = FileUtils.listFiles( file, ext, true );
        for( File file2 : files )
          tModfolderFiles.add( new PackSecurityModListEntry( file2 ) );

        synchronized( modListLock )
        {
          _mModfolderFiles = tModfolderFiles;
          MainRegistry.Logger.info( String.format( "Parsed %d .jar files:", _mModfolderFiles.size() ) );
          for( PackSecurityModListEntry pse : _mModfolderFiles )
            MainRegistry.Logger.info( String.format( "File: [%s] Hash: [%s]", pse.ModFileName, pse.FileHash ) );
        }
      }
    } ).start();
  }

  /**
   * ServerSide event
   *
   * @param pEvent
   */
  @SubscribeEvent
  public void onPlayerJoin( PlayerEvent.PlayerLoggedInEvent pEvent )
  {
    if( pEvent.player instanceof EntityPlayerMP )
    {
      String tConnectionUUID = pEvent.player.getUniqueID().toString();
      String tSecret = UUID.randomUUID().toString();
      synchronized( pendingConnectionsLock )
      {
        _mPendingConnectionSecrets.put( tConnectionUUID, new ClientAuthorizedState( tSecret ) );
      }

      MainRegistry.NW.sendTo( new PackSecurityHandShake( tSecret ), (EntityPlayerMP) pEvent.player );
    }
  }

  public void inboundClientReply( UUID pUUID, NBTTagCompound pPayload )
  {
    ClientAuthorizedState tAuthState;
    synchronized( pendingConnectionsLock )
    {
      if( !_mPendingConnectionSecrets.containsKey( pUUID.toString() ) )
        return;

      tAuthState = _mPendingConnectionSecrets.get( pUUID.toString() );
    }

    try
    {
      TripleDES tDes = new TripleDES( tAuthState.ClientSecret );

      List<PackSecurityModListEntry> tModFiles = new ArrayList<>();
      List<PackLoadedModInfo> tModList = new ArrayList<>();

      NBTTagList tagFileList = pPayload.getTagList( "FL", Constants.NBT.TAG_COMPOUND );
      NBTTagList tagModList = pPayload.getTagList( "ML", Constants.NBT.TAG_COMPOUND );

      for( int i = 0; i < tagFileList.tagCount(); i++ )
      {
        NBTTagCompound tFileTag = tagFileList.getCompoundTagAt( i );
        String tFileName = tDes.decrypt( tFileTag.getByteArray( "FN" ) );
        String tFileHash = tDes.decrypt( tFileTag.getByteArray( "FH" ) );

        if( tFileName != null && tFileHash != null )
          tModFiles.add( new PackSecurityModListEntry( tFileName, tFileHash ) );
      }

      for( int i = 0; i < tagModList.tagCount(); i++ )
      {
        NBTTagCompound tModTag = tagFileList.getCompoundTagAt( i );
        String tModName = tDes.decrypt( tModTag.getByteArray( "MN" ) );
        String tModID = tDes.decrypt( tModTag.getByteArray( "MI" ) );
        String tModVersion = tDes.decrypt( tModTag.getByteArray( "MV" ) );

        if( tModName != null && tModID != null && tModVersion != null )
          tModList.add( new PackLoadedModInfo( tModName, tModID, tModVersion ) );
      }

      tAuthState.FilesInModsFolder = tModFiles;
      tAuthState.LoadedMods = tModList;

      MainRegistry.Logger.info( String.format( "Client [%s] is connecting with %d files in /mods/ and %d loaded Mod-Objects in total", pUUID.toString(), tAuthState.FilesInModsFolder, tAuthState.LoadedMods ) );
      
      // TODO: Add checks here to verify FileHashes and check for illegal loaded mods

      synchronized( pendingConnectionsLock )
      {
        _mPendingConnectionSecrets.put( pUUID.toString(), tAuthState );
      }
    }
    catch( Exception e )
    {
      MainRegistry.Logger.error( String.format( "Error while reading encrypted client response. Client seems to be tampered! UserID: %s", pUUID.toString() ) );
    }
  }
}

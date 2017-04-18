package com.dreammaster.network.msg;


import com.dreammaster.auxiliary.TripleDES;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.packsecurity.containerClasses.PackSecurityModListEntry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

import eu.usrv.yamcore.network.server.AbstractServerMessageHandler;
import io.netty.buffer.ByteBuf;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class PackSecurityReply implements IMessage
{
  protected NBTTagCompound mPayload;

  @Override
  public void fromBytes( ByteBuf pBuffer )
  {
    mPayload = ByteBufUtils.readTag( pBuffer );
  }

  @Override
  public void toBytes( ByteBuf pBuffer )
  {
    ByteBufUtils.writeTag( pBuffer, mPayload );
  }

  public PackSecurityReply()
  {
  }

  public PackSecurityReply( int pServerSecret )
  {
    mPayload = new NBTTagCompound();

    try
    {
      TripleDES tDes = new TripleDES( String.format( "%d", pServerSecret ) );

      NBTTagList tFilesTagList = new NBTTagList();
      NBTTagList tModTagList = new NBTTagList();
      for( PackSecurityModListEntry PSMLE : MainRegistry.PSE.getModFilePayload() )
      {
        NBTTagCompound tFileEntry = new NBTTagCompound();
        tFileEntry.setByteArray( "FN", tDes.encrypt( PSMLE.ModFileName ) );
        tFileEntry.setByteArray( "FH", tDes.encrypt( PSMLE.FileHash ) );
        tFilesTagList.appendTag( tFileEntry );
      }

      for( ModContainer mc : Loader.instance().getModList() )
      {
        NBTTagCompound tModEntry = new NBTTagCompound();
        tModEntry.setByteArray( "MN", tDes.encrypt( mc.getName() ) );
        tModEntry.setByteArray( "MI", tDes.encrypt( mc.getModId() ) );
        tModEntry.setByteArray( "MV", tDes.encrypt( mc.getVersion() ) );
        tModTagList.appendTag( tModEntry );
      }

      mPayload.setTag( "FL", tFilesTagList );
      mPayload.setTag( "ML", tModTagList );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
  }

  public static class PackSecurityHandShakeHandler extends AbstractServerMessageHandler<PackSecurityReply>
  {

    @Override public IMessage handleServerMessage( EntityPlayer player, PackSecurityReply message, MessageContext ctx )
    {
      MainRegistry.PSE.inboundClientReply( player.getUniqueID(), message.mPayload );
      return null;
    }
  }
}

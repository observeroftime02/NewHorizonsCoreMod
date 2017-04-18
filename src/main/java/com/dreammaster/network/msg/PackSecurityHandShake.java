package com.dreammaster.network.msg;


import com.dreammaster.auxiliary.TripleDES;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.packsecurity.PackSecurityHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import eu.usrv.yamcore.network.client.AbstractClientMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;


public class PackSecurityHandShake implements IMessage
{
  private String _mServerSecret;

  public PackSecurityHandShake()
  {
  }

  public PackSecurityHandShake( String pSecret )
  {
    _mServerSecret = pSecret;
  }

  @Override public void fromBytes( ByteBuf buf )
  {
    int tLenSecret = buf.readInt();
    byte tEncryptedBuffer[] = new byte[tLenSecret];

    buf.readBytes( tEncryptedBuffer, 0, tLenSecret );

    try
    {
      TripleDES tDes = new TripleDES( PackSecurityHandler.SharedSecret );
      _mServerSecret = tDes.decrypt( tEncryptedBuffer );
    }
    catch (Exception e)
    {
      _mServerSecret = "";
      MainRegistry.Logger.error( "Unable to verify Pack-Integrity. Decoding ServerSecret failed" );
      e.printStackTrace();
    }
    MainRegistry.Logger.info( String.format( "Got ServerSecret: [%s]", _mServerSecret ) );
  }

  @Override public void toBytes( ByteBuf buf )
  {
    try
    {
      TripleDES tDes = new TripleDES( PackSecurityHandler.SharedSecret );
      byte[] encryptedSecret = tDes.encrypt( _mServerSecret );
      buf.writeInt( encryptedSecret.length );
      buf.writeBytes( encryptedSecret );
    }
    catch (Exception e)
    {
      _mServerSecret = "";
      MainRegistry.Logger.error( "Unable to verify Pack-Integrity. Encoding ServerSecret failed" );
      e.printStackTrace();
    }
    MainRegistry.Logger.info( String.format( "Encoded ServerSecret: [%s]", _mServerSecret ) );
  }

  public static class PackSecurityHandShakeHandler extends AbstractClientMessageHandler<PackSecurityHandShake>
  {
    @Override public IMessage handleClientMessage( EntityPlayer player, PackSecurityHandShake message, MessageContext ctx )
    {
      return new PackSecurityReply( message._mServerSecret );
    }
  }
}

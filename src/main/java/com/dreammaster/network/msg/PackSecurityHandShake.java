package com.dreammaster.network.msg;


import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import eu.usrv.yamcore.network.client.AbstractClientMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;


public class PackSecurityHandShake implements IMessage
{
  private int _mServerSecret;

  public PackSecurityHandShake()
  {
  }

  public PackSecurityHandShake( int pSecret )
  {
    _mServerSecret = pSecret;
  }

  @Override public void fromBytes( ByteBuf buf )
  {
    _mServerSecret = buf.readInt();
  }

  @Override public void toBytes( ByteBuf buf )
  {
    buf.writeInt( _mServerSecret );
  }

  public static class PackSecurityHandShakeHandler extends AbstractClientMessageHandler<PackSecurityHandShake>
  {
    @Override public IMessage handleClientMessage( EntityPlayer player, PackSecurityHandShake message, MessageContext ctx )
    {
      return new PackSecurityReply( message._mServerSecret );
    }
  }
}

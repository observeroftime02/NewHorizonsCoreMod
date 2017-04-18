package com.dreammaster.network;


import com.dreammaster.lib.Refstrings;
import com.dreammaster.network.msg.CTTClientSyncMessage;
import com.dreammaster.network.msg.PackSecurityHandShake;
import eu.usrv.yamcore.network.PacketDispatcher;


public class CoreModDispatcher extends PacketDispatcher
{

  public CoreModDispatcher()
  {
    super( Refstrings.MODID );
  }

  @Override
  public void registerPackets()
  {
    registerMessage( CTTClientSyncMessage.CTTClientSyncMessageHandler.class, CTTClientSyncMessage.class );
    registerMessage( PackSecurityHandShake.PackSecurityHandShakeHandler.class, PackSecurityHandShake.class );
  }
}

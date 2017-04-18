package com.dreammaster.packsecurity.containerClasses;


import com.dreammaster.main.MainRegistry;

import java.util.UUID;


public class PackSecurityPendingConnection
{
  public UUID ClientUUID;
  public int RandomSecret;

  public PackSecurityPendingConnection( UUID pClientUUID )
  {
    ClientUUID = pClientUUID;
    RandomSecret = MainRegistry.Rnd.nextInt( Integer.MAX_VALUE );
  }
}

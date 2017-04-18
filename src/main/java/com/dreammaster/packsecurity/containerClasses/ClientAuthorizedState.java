package com.dreammaster.packsecurity.containerClasses;


import java.util.ArrayList;
import java.util.List;


public class ClientAuthorizedState
{
  public int ClientSecret;
  public boolean IsLegitClient;
  public List<PackSecurityModListEntry> FilesInModsFolder;
  public List<PackLoadedModInfo> LoadedMods;

  public ClientAuthorizedState( int pClientSecret )
  {
    ClientSecret = pClientSecret;
    IsLegitClient = false;
    FilesInModsFolder = new ArrayList<>();
    LoadedMods = new ArrayList<>();
  }
}

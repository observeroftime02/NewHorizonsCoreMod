package com.dreammaster.packsecurity.containerClasses;


import java.util.ArrayList;
import java.util.List;


public class ClientAuthorizedState
{
  public String ClientSecret;
  public boolean IsLegitClient;
  public List<PackSecurityModListEntry> FilesInModsFolder;
  public List<PackLoadedModInfo> LoadedMods;

  public ClientAuthorizedState( String pClientSecret )
  {
    ClientSecret = pClientSecret;
    IsLegitClient = false;
    FilesInModsFolder = new ArrayList<>();
    LoadedMods = new ArrayList<>();
  }
}

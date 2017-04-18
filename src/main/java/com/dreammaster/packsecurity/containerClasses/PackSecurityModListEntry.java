package com.dreammaster.packsecurity.containerClasses;


import com.dreammaster.auxiliary.SHA1Digest;

import java.io.File;


public class PackSecurityModListEntry
{
  public String ModFileName;
  public String FileHash;

  public PackSecurityModListEntry( File pFilePath )
  {
    ModFileName = pFilePath.getName();
    try
    {
      FileHash = SHA1Digest.calcSHA1( pFilePath );
    }
    catch( Exception e )
    {
      FileHash = "ERROR";
    }
  }

  public PackSecurityModListEntry( String pFileName, String pFileHash )
  {
    ModFileName = pFileName;
    FileHash = pFileHash;
  }
}

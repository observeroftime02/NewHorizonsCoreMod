package com.dreammaster.auxiliary;


import java.util.ArrayList;
import java.util.List;


public class StringHelper
{
  public static List<String> splitByLength( String pInput, int pChunkSize )
  {
    List<String> tReturnList = new ArrayList<>();

    for( int i = 0; i < pInput.length(); i = i + pChunkSize )
    {
      if( pInput.length() - i < pChunkSize )
        tReturnList.add( pInput.substring( i ) );
      else
        tReturnList.add( pInput.substring( i, i + pChunkSize ) );
    }

    return tReturnList;
  }
}

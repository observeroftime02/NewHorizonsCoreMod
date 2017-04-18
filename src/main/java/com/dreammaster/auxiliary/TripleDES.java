package com.dreammaster.auxiliary;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;


public class TripleDES
{
  private static final String UNICODE_FORMAT = "UTF8";
  private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
  private Cipher _mCipher;
  private SecretKey _mKey;

  public TripleDES( String pKey ) throws Exception
  {
    String tEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
    byte[] tArrayBytes = pKey.getBytes( UNICODE_FORMAT );
    KeySpec ks = new DESedeKeySpec( tArrayBytes );
    SecretKeyFactory skf = SecretKeyFactory.getInstance( tEncryptionScheme );
    _mCipher = Cipher.getInstance( tEncryptionScheme );
    _mKey = skf.generateSecret( ks );
  }

  public byte[] encrypt( String unencryptedString )
  {
    byte[] encryptedText = null;
    try
    {
      _mCipher.init( Cipher.ENCRYPT_MODE, _mKey );
      byte[] plainText = unencryptedString.getBytes( UNICODE_FORMAT );
      encryptedText = _mCipher.doFinal( plainText );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
    return encryptedText;
  }

  public String decrypt( byte[] encryptedString )
  {
    String decryptedText = null;
    try
    {
      _mCipher.init( Cipher.DECRYPT_MODE, _mKey );
      byte[] plainText = _mCipher.doFinal( encryptedString );
      decryptedText = new String( plainText );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
    return decryptedText;
  }
}

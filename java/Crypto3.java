import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;


public class Crypto3 
{
	public static void main(String [] args)
	{
		System.out.println("No body can see me.");
		try 
		{		


			byte[] text = "No body can see me.".getBytes("UTF-8");         // Normal String converted to bytes with encoding
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");  //  Get KeyGen  of a particular Algorithm in this case DES
			SecretKey secret = keyGenerator.generateKey();	    // Secret Key -- generate Key using Key Generator above		


			Cipher myCipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); // Get the Cipher Computation Engine with Algo and Padding
			myCipher.init(Cipher.ENCRYPT_MODE, secret);	    // Set mode and the key
			byte[] textEncrypted = myCipher.doFinal(text);      // encrypt the plain text	



			File file = new File("NewEnc.enc");
			FileOutputStream stream = new FileOutputStream(file);			 
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			byteStream.write(textEncrypted, 0, textEncrypted.length);
			byteStream.writeTo(stream);
			stream.flush();
			stream.close();
			

			System.out.println(textEncrypted);  // Spit out the encryption logic
			textEncrypted = null;

			FileInputStream inStream = new FileInputStream(file);
			textEncrypted = new byte[inStream.available()];			
			inStream.read(textEncrypted);


			IvParameterSpec spec = new IvParameterSpec(myCipher.getIV());  // get the encryption Spec 
			myCipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); // Get the Cipher Computation Engine with Algo and Padding
			myCipher.init(Cipher.DECRYPT_MODE, secret, spec);   // Rest the Cipher Engine to Decrypt mode, key and the spec
			byte[] textDecrypted = myCipher.doFinal(textEncrypted);  // Decrypt the ecnrypted info

			System.out.println(new String(textDecrypted));   // Spit out the information
			inStream.close();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}				

	}
}

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


public class Crypto4 
{
	public static void main(String [] args)
	{
		String plainText = "No body can see me.\r\n This will not get encrypted";
		System.out.println(plainText);
		try 
		{		
			byte [] algoSpec = {'0', '0', '0', '0', '0', '0', '0', '0'};
			IvParameterSpec spec = new IvParameterSpec(algoSpec);  // get the encryption Spec 
			byte[] text = plainText.getBytes("UTF-8");  // Normal String converted to bytes with encoding
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");  //  Get KeyGen  of a particular Algorithm in this case DES
			SecretKey secret = keyGenerator.generateKey();	    // Secret Key -- generate Key using Key Generator above		


			Cipher myCipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); // Get the Cipher Computation Engine with Algo and Padding
			myCipher.init(Cipher.ENCRYPT_MODE, secret, spec);	    // Set mode and the key
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
			myCipher = null;
			text = null;

			FileInputStream inStream = new FileInputStream(file);
			textEncrypted = new byte[inStream.available()];			
			inStream.read(textEncrypted);



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

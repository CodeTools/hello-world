import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

import java.security.NoSuchAlgorithmException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.OutputStream;




public class Crypto5 
{
	public static void main(String [] args)
	{
		try 
		{
			String plainText = null;
			File inputfile = new File("Encryption.in");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputfile)));
			String str = null;
			StringBuilder builder = new StringBuilder("");
			while((str = reader.readLine()) != null) 
			{
				builder.append(str);
				builder.append("\r\n");
			}
			plainText = builder.toString();
			System.out.println(plainText);

		
			byte [] algoSpec = {'0', '0', '0', '0', '0', '0', '0', '0'};
			IvParameterSpec spec = new IvParameterSpec(algoSpec);  // get the encryption Spec 
			byte[] text = plainText.getBytes("UTF-8");  // Normal String converted to bytes with encoding
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");  //  Get KeyGen  of a particular Algorithm in this case DES
			SecretKey secret = keyGenerator.generateKey();	    // Secret Key -- generate Key using Key Generator above		


			Cipher myCipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); // Get the Cipher Computation Engine with Algo and Padding
			myCipher.init(Cipher.ENCRYPT_MODE, secret, spec);	    // Set mode and the key
			byte[] textEncrypted = myCipher.doFinal(text);      // encrypt the plain text	



			File file = new File("NewEnc.enc");                     // encrypted file
			FileOutputStream stream = new FileOutputStream(file);	// file stream created		 
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();   // byte array stream to write the bytes
			byteStream.write(textEncrypted, 0, textEncrypted.length);         // bytes written
			byteStream.writeTo(stream);             // byte array written to the underlying file stream which will write to the file
			stream.flush();
			stream.close();                 // flush and close
			

			System.out.println(textEncrypted);  // Spit out the encryption logic
			textEncrypted = null;
			myCipher = null;
			text = null;

			FileInputStream inStream = new FileInputStream(file);      // get the encrypted file
			textEncrypted = new byte[inStream.available()];		   // create a new array of bytes	
			inStream.read(textEncrypted);                              // read the bytes in the array from stream



			myCipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); // Get the Cipher Computation Engine with Algo and Padding
			myCipher.init(Cipher.DECRYPT_MODE, secret, spec);   // Rest the Cipher Engine to Decrypt mode, key and the spec
			byte[] textDecrypted = myCipher.doFinal(textEncrypted);  // Decrypt the ecnrypted info
			String textD = new String(textDecrypted);
			System.out.println(textD);   // Spit out the information


			File outputfile = new File("Decryption.out");          // get an output file			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfile))); // get the writer
			writer.write(textD, 0, textD.length());    // write the bytes from the zero postion to the last postion

	 
			inStream.close();   // close the stream
			writer.flush();     // flush the writer
			writer.close();     // close the writer
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}				

	}
}

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.IvParameterSpec;



import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;





public class FileEncryptor
{
	public static void main(String [] args)
	{
		try
		{
			//System.out.println("\r\n");
			String str = load("E:\\myfiles\\short_programs\\java\\FileEncryptor2.java");
			//System.out.println(str);
			write("Encrypted.enc", encrypt(str));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static String load(String fileName) throws FileNotFoundException, IOException
	{
		String str = null;
		StringBuilder builder = new StringBuilder("");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
		while((str = reader.readLine()) != null) 
		{
			builder.append(str + "\n");
		}
		reader.close();
		return builder.toString();
	}


	private static void write(String name, byte [] bytes) throws FileNotFoundException, IOException
	{
		FileOutputStream outputStream = new FileOutputStream(new File(name));
		System.out.println(bytes);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes.length);
		byteArrayOutputStream.write(bytes, 0, bytes.length);
		byteArrayOutputStream.writeTo(outputStream);
		outputStream.flush();
		outputStream.close();
	}


	private static byte [] encrypt(String text)	throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
	{
		
		byte [] bytes = text.getBytes("UTF-8");                                 // get the Bytes

		KeyGenerator keyGen = KeyGenerator.getInstance("DES");			// get the Key Generator

		SecretKey secretKey = keyGen.generateKey();		                // Get the Secret Key

		Cipher engine = Cipher.getInstance("DES/CBC/PKCS5Padding");		// Get the instance of the Cipher Engine

		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0};
		IvParameterSpec ivSpec = new IvParameterSpec(iv);	

		engine.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);     	        // Initiatlize the Cipher Engine with Encrypt Mode
		
		//System.out.println("Parameters used " + engine.getIV());

		return engine.doFinal(bytes);			                        // encrypt
	}
		
}
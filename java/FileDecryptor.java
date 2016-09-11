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
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;







public class FileDecryptor
{
	public static void main(String [] args)
	{
		try
		{
			System.out.println("\r\n");
			byte [] bytes = load("E:\\myfiles\\short_programs\\java\\Encrypted.enc");
			System.out.println(bytes);
			decrypt(bytes);
			//write("FileDecrypted.java", decrypt(bytes));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	


	private static String write(String fileName) 
	{
		return null;
	}



	private static byte [] load(String fileName) throws FileNotFoundException, IOException
	{
		String str = null;
		byte [] bytes = null;
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		System.out.println(fileInputStream.available());
		bytes = new byte[fileInputStream.available()];
		System.out.println(bytes.length);
		fileInputStream.read(bytes);
		return bytes;
	}



	private static byte [] decrypt(byte [] bytes) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
	{
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");			// get the Key Generator

		SecretKey secretKey = keyGen.generateKey();		                // Get the Secret Key

		Cipher engine = Cipher.getInstance("DES/CBC/PKCS5Padding");		// Get the instance of the Cipher Engine

		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0};
		IvParameterSpec ivSpec = new IvParameterSpec(iv);	

		engine.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);	                // Initiatlize the Cipher Engine with Encrypt Mode

		System.out.println("Parameters used " + engine.getIV());

		return engine.doFinal(bytes);			                        // decrypt	
	}
}

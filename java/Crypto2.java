import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Crypto2 
{

	static Cipher cipher = null;
	static KeyGenerator keyGen = null;
	static SecretKey key = null;
	static IvParameterSpec spec = null;

	public static void main(String [] args) 
	{
		System.out.println("Crypto 2");

		String plainText = "I am encrypted";
		try
		{
			// Print the plain Text
			System.out.println("plain text->" + plainText);	


			// Print the encrypted Text
			byte [] enc = encrypt(plainText);
			System.out.println("Encrypted text->" + new String(enc));



			// Print the decrypted Text
			byte [] dec = decrypt(enc);
			System.out.println("Decrypted text->" + new String(dec));
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	static byte[] encrypt(String plainText)  throws Exception
	{
		byte [] encrypted = null;
		keyGen = KeyGenerator.getInstance("DES");                  // Get a KeyGenerator 
		key = keyGen.generateKey();                                // Generate a key  : ByTheWay FoodForThought why two steps to get a key
		cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");       // get the Cipher Engine you want with a Algo and padding
		byte [] text =  plainText.getBytes("UTF-8");               // We need the bytes so convert the String WITH encoding to bytes
		cipher.init(Cipher.ENCRYPT_MODE, key);                     // Initialize the Cipher key with encrypt mode : Seriously why not call a encrypt meth 
		encrypted = cipher.doFinal(text);                          // actually do the encryption. : Why this is a doFinal method ?
		spec = new IvParameterSpec(cipher.getIV());                // ok we build a new Initialization Vector 
		return encrypted;
	}



	static byte[] decrypt(byte [] encrypted)  throws Exception
	{
		byte [] decrypted = null;
		cipher.init(Cipher.DECRYPT_MODE, key, spec);
		decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}
}
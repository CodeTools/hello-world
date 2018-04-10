import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;


import java.io.*;


class FileLoader {
   File input;
   BufferedReader reader;


   FileLoader(String fileName) throws IOException {
	input = new File(fileName);	
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
   }


   String read() throws IOException {
	StringBuilder builder = new StringBuilder("");
        String str = null;
        while((str = reader.readLine()) != null) {
		builder.append(str);	
	}
	return builder.toString();
   }

   void close() throws IOException {
	reader.close();
   }
}

class FileDumper {
   File output;
   BufferedWriter writer;

   FileDumper(String fileName) throws Exception {
	output = new File(fileName);
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
   }


   void write(String data) throws IOException {
	writer.write(data);
   }


   void flushAndClose() throws IOException {
	writer.flush();
        writer.close();
   }

}

class DesEncrypter {
  Cipher ecipher;

  Cipher dcipher;



  DesEncrypter(SecretKey key) throws Exception {
    ecipher = Cipher.getInstance("DES");
    dcipher = Cipher.getInstance("DES");
    ecipher.init(Cipher.ENCRYPT_MODE, key);
    dcipher.init(Cipher.DECRYPT_MODE, key);
  }




  public String encrypt(String str) throws Exception {
    // Encode the string into bytes using utf-8
    byte[] utf8 = str.getBytes("UTF8");

    // Encrypt
    byte[] enc = ecipher.doFinal(utf8);

    // Encode bytes to base64 to get a string
    return Base64.getEncoder().encodeToString(enc);
  }



  public String decrypt(String str) throws Exception {
    // Decode base64 to get bytes
    byte[] dec = Base64.getDecoder().decode(str);

    byte[] utf8 = dcipher.doFinal(dec);

    // Decode using utf-8
    return new String(utf8, "UTF8");
  }
}




public class Main5 {
  public static void main(String[] argv) throws Exception {
    FileDumper dumper = new FileDumper("more.enc");
    SecretKey key = KeyGenerator.getInstance("DES").generateKey();
    DesEncrypter encrypter = new DesEncrypter(key);
    String plainText = "Don't tell anybody!";
    System.out.println(plainText);
    String encrypted = encrypter.encrypt(plainText);
    dumper.write(encrypted);
    dumper.flushAndClose();
			
    encrypted = null;
    FileLoader loader = new FileLoader("more.enc");
    encrypted = loader.read();
    String decrypted = encrypter.decrypt(encrypted);
    System.out.println(decrypted);
    loader.close();
  }
}
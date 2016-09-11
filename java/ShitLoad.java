import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.io.FileNotFoundException;
import java.io.IOException;



/** 
 *
 * Uses File Channel to read a File
 *
 *
 **/
public class ShitLoad 
{
	public static void main(String [] args)
	{
				
		try 
		{
			RandomAccessFile file = new RandomAccessFile("ShitLoad.input", "r");
			FileChannel channel = file.getChannel();			
			ByteBuffer aBuffer = ByteBuffer.allocate(1024);
			while (channel.read(aBuffer) > 0) 
			{
				System.out.println("Inside loop");
				aBuffer.flip();				
				while(aBuffer.hasRemaining()) System.out.print( (char) aBuffer.get());				
				aBuffer.clear();
			}
			file.close();			
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e);	
		}
		catch(IOException e)
		{
			System.err.println(e);	
		}

	}
}
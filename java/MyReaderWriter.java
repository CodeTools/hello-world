import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class MyReaderWriter
{
	public static void main(String [] args)
	{
		try
		{
			System.out.println("\r\nMyReaderWriter");
			RandomAccessFile file = new RandomAccessFile("MyReaderWriter.java", "r");
			FileChannel channel = file.getChannel();
			System.out.println(" file " + file);
			System.out.println(" channel " + channel);
			file.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File Not Found ");
		}
		catch(IOException e)
		{
			System.err.println("Some IO Exception ");
		}
		
	}
}
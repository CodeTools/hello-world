import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;



public class Elevator
{
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static final Elevator elevator = new Elevator();


	public Elevator()
	{
	}

	public 	BufferedReader getReader() throws IOException
	{
		return reader;
	}


	public 	BufferedWriter getWriter() throws IOException
	{
		return writer;
	}

	public void write(String s) throws IOException
	{
		writer.write(s);
	}

	public String read() throws IOException
	{	
		return reader.readLine();
	}

	public void flush() throws IOException
	{
		writer.flush();
	}

	public void close() throws IOException
	{
		reader.close();
		reader.close();
	}


	public static void main(String [] args) throws Exception
	{	
		String s = elevator.read();
		while(s != null)
		{
			s = elevator.process(s);
			elevator.write(s);
			elevator.write("\r\n");
			s = elevator.read();	
		}
		elevator.flush();
		elevator.close();		
		 
	}


	public String process(String s)
	{
		return s;
	}
	
}
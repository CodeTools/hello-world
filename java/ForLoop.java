import java.io.LineNumberReader;
import java.io.InputStreamReader;

public class ForLoop
{
	public static void main(String [] args)
	{
		try
		{
			LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(System.in));
			String str = lineNumberReader.readLine();
			int count = 0;
			System.out.println("\r\n");
			while(str != null)
			{
				count = lineNumberReader.getLineNumber();
				System.out.println(count + ":" +str);				
				str = lineNumberReader.readLine();				
			}
			System.out.println("\r\n");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
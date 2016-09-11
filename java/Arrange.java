import static java.lang.System.out;
import static java.lang.System.in;
import        java.util.Scanner;
import        java.io.PrintStream;
import        java.util.List;
import        java.util.ArrayList;


public class Arrange
{

	private static PrintStream StdOut = out;
	private static Scanner scanner = new Scanner(in);
	
	public static void main(String [] args)
	{
		Integer T = scanner.nextInt();
		while(T > 0) 
		{
			StdOut.println(check(scanner.next()));			
			T--;
		}
	}

	private static String check(String str)
	{
		String returnString = "1";
		return returnString;
	}
	
}
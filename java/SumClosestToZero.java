import java.util.Scanner;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import static java.lang.Math.abs;


public class SumClosestToZero
{

	private static Scanner scanner = new Scanner(System.in);
	private static PrintStream StdOut = System.out;
	
	public static void main(String [] args)
	{
		Integer testCases = scanner.nextInt();		 
		for(int testCase=0;testCase<testCases;testCase++)
		{
			Integer X = scanner.nextInt();

			Integer P [] = new Integer[X];
			for(int looper=0;looper<P.length;looper++) 
			{
				P[looper] = scanner.nextInt();
			}  
			String sum = closestToZero(X, P).toString();
			printInFormat(sum, testCase);
		}
	}

	public static void print(String s)
	{
		StdOut.println(s);		
	}

	public static void printInFormat(String s, Integer testCase)
	{
		StdOut.println("Case #" + testCase + " :" + s);
	}

	private static List<Integer> closestToZero(Integer X, Integer P[])
	{
		List<Integer> list = new ArrayList<Integer>(2);
		list.add(Integer.MAX_VALUE);
		list.add(Integer.MAX_VALUE);
		List<Integer> numbers = Arrays.asList(P);
		Collections.sort(numbers, getComparator());
		print(numbers.toString());
		Integer first = Integer.MAX_VALUE;
		Integer second = Integer.MAX_VALUE;
		Integer min = Integer.MAX_VALUE;
		for(int i=0;i<numbers.size() - 1;i++)
		{
			first = numbers.get(i);	
			second = numbers.get(i + 1);
			if(min > (first + second))
			{
				min = (first + second);
				list.set(0, first);
				list.set(1, second);
				print(" first " + first + " second " + second + " min " + min);
			}	
		}
		return list;
	}

	private static Comparator<Integer> getComparator() 
	{
		return new Comparator<Integer>() 
		{
			public int compare(Integer integer1, Integer integer2)
			{
				if(abs(integer1.intValue()) > abs(integer2.intValue())) return 1;
				else if(abs(integer1.intValue()) < abs(integer2.intValue())) return -1;
				else return 0;
			}
		};
	}
}
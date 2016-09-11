import java.util.Scanner;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;



public class InfiniteHouseOfPancakes 
{

	private static Scanner scanner = new Scanner(System.in);
	private static PrintStream StdOut = System.out;
	

	public static void main(String [] args) 
	{
		Integer testCases = scanner.nextInt();
		for(int testCase = 1;testCase <= testCases;testCase++) 
		{
			Integer D = scanner.nextInt();
			Integer P [] = new Integer[D];			
			for(int d = 0;d < D;d++) 
			{
				P[d] = scanner.nextInt();				
			}
			Integer minutes = getMinutes(D, P);
			print("" + minutes, testCase);
		}
		
	}
	
	private static Integer getMinutes(Integer D, Integer P []) 
	{
		Integer minutes = 0;
		List<Integer> list = new LinkedList<Integer>();
		for(int index=0;index<P.length;index++) 
		{
			list.add(P[index]);
		}		
		// writing the bad Strategy
		while(!list.isEmpty()) // check if the list has any elements
		{
			for(int i=0;i<list.size();i++) // Iterate over the list
			{
				list = eat(list, i);// eat pancake
				minutes++;// increment minutes
			}
		}
		return minutes;
	}
	
	private static List<Integer> specialMinute(List<Integer> list)
	{
		return list;
	}
	
	private static List<Integer> eat(List<Integer> list, Integer index)
	{
		StdOut.println(" list " + list);
		Integer element = list.get(index);
		if(element == 1) 
		{
			list.set(index, null);
		}
		else 
		{
			element--;
			list.set(index, element);
		}
		return list;
	}
	
	
	private static void print(String s, Integer i) 
	{
		StdOut.println("Case #" + i + ": " + s);
	}
}
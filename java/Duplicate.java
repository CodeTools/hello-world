import java.util.Scanner;
import java.io.PrintStream;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;




/**
 *
 * Segregates Duplicates and Uniques from a List of Numbers. Tested with the following data samples
 *
 * Sample 1.
 *
 * Input:
 * 20
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 *
 * Output:
 * Duplicates
 * Uniques
 * 0
 * 1
 * 2 
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * Dump
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 *
 *
 *
 **/
public class Duplicate 
{

	private Scanner in = new Scanner(System.in);
	private PrintStream out = System.out;

	/**
	 *
	 * Public Constructor
	 *
  	 **/	
	public Duplicate()
	{
		
	}


	
	/**
	 *
	 * Main method
	 *
  	 **/	
	public static void main(String [] args)
	{
		Duplicate duplicate = new Duplicate();			

		Integer T = duplicate.readInteger();
		Set<Integer> set = new HashSet<Integer>();		
		List<Integer> duplicates = new LinkedList<Integer>();
		List<Integer> uniques = new LinkedList<Integer>();
		List<Integer> dump = new ArrayList<Integer>();

		
		
		while(T > 0)
		{
			Integer s = duplicate.readInteger();			
			if(set.contains(s) && !duplicates.contains(s)) 
			{
				duplicates.add(s);
			}						
			set.add(s);
			dump.add(s);			
			T--;
		}

		for(Integer s : set)
		{
			if(dump.indexOf(s) == dump.lastIndexOf(s))
			{
				uniques.add(s);
			}
		}

		
		duplicate.write("Duplicates");
		duplicate.write(duplicates);
		duplicate.write("Uniques");
		duplicate.write(uniques);
		duplicate.write("Dump");
		duplicate.write(dump);
	}
	

	/**
	 *
	 *
	 *
  	 **/
	public final <T> Collection<T> wrapSingleton(T t)
	{
		Collection<T> collection = new LinkedList<T>();
		collection.add(t);
		return collection;
	}

	
	/**
	 *
	 *
	 *
  	 **/
	public final void write(String s)
	{
		out.println(s);
	}

	
	/**
	 *
	 *
	 *
  	 **/
	public final void write(Integer i)
	{
		out.println("" + i);
	}
	

	/**
	 *
	 *
	 *
  	 **/
	public final <T> void write(List<T> list)
	{
		if(list != null)
		{
			for(T t : list) out.println(""+t);
		}
	}

	
	/**
	 *
	 *
	 *
  	 **/
	public final <T> void write(Set<T> set)
	{
		if(set != null)
		{
			for(T t : set) out.println(""+t);
		}
	}

	
	/**
	 *
	 *
	 *
  	 **/
	public final String read()
	{
		return in.next();
	}

	
	/**
	 *
	 *
	 *
  	 **/
	public final Integer readInteger()
	{
		return in.nextInt();
	}


	
	/**
	 *
	 *
	 *
  	 **/
	public final boolean hasNext()
	{
		return in.hasNext();
	}
}
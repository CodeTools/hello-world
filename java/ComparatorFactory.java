import java.util.Comparator;



public class ComparatorFactory<T extends Comparable<T>> implements Comparator<T>
{
	public static void main(String [] args)
	{
	
		Integer i = 100;
		Integer j = 102;
		System.out.println(i.compareTo(j));
		ComparatorFactory<Integer> factory = new ComparatorFactory<Integer>();
		System.out.println(factory.compare(i, j));		




		String s = "100";
		String r = "101";
		System.out.println(s.compareTo(r));
		ComparatorFactory<String> factory2 = new ComparatorFactory<String>();
		System.out.println(factory2.compare(s, r));
	}


	public int compare(T t1, T t2) // throws Exception
	{
		return t1.compareTo(t2);
	}	
	
}
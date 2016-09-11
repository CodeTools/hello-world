public class Subset
{
	public static void main(String [] args)
	{
		String str = "1234";
		call("", str, 0);
	}


	public static void call(String start, String end, int start)
	{
		for(int i= start;i < end.length();i++)
		{
			System.out.print(start + end.charAt(i));
			System.out.print("----");
			System.out.println(end.substring(0, i).concat(end.substring(i + 1)));
		}	
	}
}
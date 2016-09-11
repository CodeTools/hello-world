public class ListAll
{
	public static void main(String [] args)
	{
		for(int i=0;i<args.length;i++)
			System.out.println(" File [" + i + "] -> " + args[i]);
		if(args.length<=0)
			System.out.println("No Files");
	}
}
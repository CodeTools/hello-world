public class FirstStart implements Runnable
{

	private static FirstStart start = null;
	private static Thread thread = null;	

	static 
	{
		System.out.println("\r\nStatic Block");
		start = new FirstStart();
		thread = new Thread(start);
		thread.start();		
	}	

	 
	{
		System.out.println("Instantiating");
	}


	public FirstStart() 
	{
		System.out.println("Constructors");
	}

	public static void main(String [] args) throws Exception
	{
		thread.join();
		System.out.println("\r\nFirstStart");		
	}

	public void run() 
	{
		System.out.println("\r\nRun");
	}	
}
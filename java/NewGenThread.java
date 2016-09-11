public class NewGenThread
{
	public static void main(String [] args)
	{
		new Thread(
		new Runnable() 
		{
			public void run()
			{
				System.out.println("1. Old Way");
			}
		}
		).start();




		new Thread(()->System.out.println("2. New Way")).start();
	}
}
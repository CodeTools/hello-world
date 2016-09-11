public class Dynamo
{
	public static void main(String [] args)
	{
		System.out.println("Dynamo");
		Object lock = new Object();
		Thread t1 = new Thread(new Dynamo().new DynamoRunner(lock, 1));
		Thread t2 = new Thread(new Dynamo().new DynamoRunner(lock, 2));
		t1.start();
		t2.start();
	}



	class DynamoRunner implements Runnable
	{
		Object lock;
		Integer number;
		public DynamoRunner(Object lock, Integer number)
		{
			this.lock = lock;
			this.number = number;
		}

		public void run()
		{
			
			if(number % 2 == 0)
			{
				
				System.out.println(number);	
				synchronized(lock)
				{
					
				}
			}
			else 
			{
				System.out.println(number);		
			}
								
		}
	}
}
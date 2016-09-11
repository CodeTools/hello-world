public class ConsumerProducer
{
	public static void main(String [] args)
	{
		System.out.println("\r\nConsumerProducer");
		Object lock = new Object();
		(new Thread(new HungryMe(lock))).start();
		(new Thread(new Cooker(lock))).start();
	}



	static class HungryMe implements Runnable
	{
		Object lock;
		HungryMe(Object lock){this.lock = lock;}
		public void run()
		{
			synchronized(lock)
			{
				try 
				{
					System.out.println(" I am Hungry");
					lock.wait();
					System.out.println(" Buuuurp !!!");
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
		}	
	}

	static class Cooker implements Runnable
	{
		Object lock;
		Cooker(Object lock) {this.lock = lock;}
		public void run()
		{
			synchronized(lock)
			{
				try
				{
					System.out.println(" dal tadka laga diya ");
					Thread.sleep(3000);
					System.out.println(" tadka lag gaya ");
					lock.notify();	
					System.out.println(" Served Hot. ");					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}	
		}		
	}
}
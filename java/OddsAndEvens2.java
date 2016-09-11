public class OddsAndEvens2
{
	public static void main(String [] args) throws InterruptedException
	{
		Object object = new Object();
		Thread t1 = new Thread(new OddsAndEvens2().new Odd(object));
		Thread t2 = new Thread(new OddsAndEvens2().new Even(object));
		t1.start();
		t2.start();
		
	}

	class Odd implements Runnable
	{
		Object object;
		Odd(Object object) { this.object = object;}
		public void run() 
		{
			try {	
				// wait 
				for(int i=2;i<5;i=i+2) 
				{			
					synchronized(object)
					{
					
						System.out.println("R1: Waiting for Object. Iteration :" + i);
						object.wait();					
						Thread.sleep(100);
						System.out.println("R1: Wait Completed. Iteration :" + i);						
						object.notifyAll();
						System.out.println("R1:Notify all Done. Iteration : " + i);
					}
				}
				synchronized(object) 
				{
					object.notifyAll();
				}
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}


	
	class Even implements Runnable
	{
		Object object;
		Even(Object object) { this.object = object;}
		public void run() 
		{
			try {
				// Doing some Computation
				System.out.println("Doing some computation :");
				for(int i=1;i<21;i++)
				{
					Thread.sleep(100);
					System.out.print(i + " ");
				}
				// Now notify
				System.out.println("");
				for(int i=1;i<5;i=i+2) 
				{
					synchronized(object)
					{					
						System.out.println("R2: Object to be notified. Iteration :" + i);
						object.notifyAll();					
						System.out.println("R2: Object notified. Iteration :" + i);
						object.wait();
						Thread.sleep(100);
						System.out.println("R2: Wait Completed. Iteration :" + i);
					}
				}
				synchronized(object) 
				{
					object.notifyAll();
				}				
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
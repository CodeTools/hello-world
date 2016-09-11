public class MyThread
{
	public static void main(String [] args) throws InterruptedException
	{
		Object object = new Object();
		Thread t1 = new Thread(new MyThread().new Runner2(object));
		Thread t2 = new Thread(new MyThread().new Runner1(object));
		t1.start();
		t2.start();
		
	}

	class Runner1 implements Runnable
	{
		Object object;
		Runner1(Object object) { this.object = object;}
		public void run() 
		{
			try {	
				// wait 			
				synchronized(object)
				{
					
					System.out.println("R1: Waiting for Object");
					object.wait();					
					System.out.println("R1: Wait Completed ");
				}
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}


	
	class Runner2 implements Runnable
	{
		Object object;
		Runner2(Object object) { this.object = object;}
		public void run() 
		{
			try {
				System.out.println(" Doing Some Computation ");
				// Doing some Computation
				for(int i=1;i<21;i++)
				{
					Thread.sleep(100);
					System.out.print(i + " ");
				}
				// Now notify
				System.out.println("\r\n Compuation Comlete  ");				
				synchronized(object)
				{					
					System.out.println("R2: Object to be notified");
					object.notifyAll();					
					System.out.println("R2: Object notified ");
				}
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
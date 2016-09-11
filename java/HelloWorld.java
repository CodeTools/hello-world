import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



/**
 *
 *
 *Class Without any Eclipse : DoomsDay Project
 *
 **/
public class HelloWorld   
	{


	class Runner implements Runnable 
	{


		private int run;
		private BlockingQueue<Integer> queue;


		Runner(int run) 
		{
			this.run = run;
		}

		Runner(int run, BlockingQueue<Integer> queue) 
		{
			this.run = run;
			this.queue = queue;			
			
		}

		public void run() 
		{
		try 
		{

			if(this.run < 5) 
			{
			   this.queue.put(run);
			}
			else 
			{
			   run = this.queue.take();
			}
			System.out.println("\r\nHello from " + run);
			System.out.println("\r\nQueue" + this.queue);
		}
		catch(Exception e) 
		{
			System.err.println(" Exception occurred " + e.getMessage());
		}
		}	

	}





	/**
	 *
	 *
	 * main method
	 *
	 **/
	public static void main(String [] args) 
	{

		Thread [] threads = new Thread[10];
		HelloWorld hw = new HelloWorld();

		ExecutorService service = Executors.newFixedThreadPool(10);
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();


		try 
		{

		
	
		    System.out.println("\n Hello World");
		    System.out.println("Now printing the numbers 1 to 100");

		    for(int i=0;i<10;i++) 
		    {
			service.submit(hw.new Runner(i, queue));
			System.out.println("Submitting Task  [ " + i + " ] ");
		    }

		    service.shutdownNow();
		
		    while(!service.awaitTermination(1000, TimeUnit.MILLISECONDS)) 
		    {
			System.err.println("Unable to shut down task. ");
			if(service.isTerminated()) 
			{
			   System.out.println("Service has been shut down.");
			   break;
			}
		    }
		    System.out.println("\n Hi From Sanjay");
	


		}
		catch(Exception e) 
		{
		  System.err.println("exception " + e.getMessage());
		  e.printStackTrace();
		}

	}
}
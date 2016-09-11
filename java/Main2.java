import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CountDownLatch;

/**
 *
 * Main class V2
 *
 **/
public class Main2 
{
	/**
	 *
	 * main method
	 *
	 **/
	public static void main(String [] args) 
	{
		try
		{
			CountDownLatch drive = new CountDownLatch(1);
			CountDownLatch worker = new CountDownLatch(10);
			ExecutorService executor = Executors.newFixedThreadPool(5);
			Runner driver = new Runner(true, drive, worker);
			executor.submit(driver);
			Runner workers [] = new Runner[10];
			for(int i=0;i<10;i++) 
			{
				workers[i] = new Runner(drive, worker); 
				executor.submit(workers[i]);
			}
			executor.shutdownNow();
			while(executor.isTerminated() == false) {
				System.err.println("waiting for shutdown. Sleeping for 100 ms.");
				Thread.sleep(100);
			}

			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	
	}
}
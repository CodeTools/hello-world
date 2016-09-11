import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.Set;
import java.util.LinkedHashSet;


public class FactorialCaller
{
	public static void main(String [] args) throws Exception
	{
		try
		{
			System.out.println("\r\nFactorialCaller");
			Callable [] factorials = new FactorialCalculator[10];
			ExecutorService service = Executors.newCachedThreadPool();
			Set<Future<Integer>> futures = new LinkedHashSet<Future<Integer>>();
			for(int loop=0;loop<10;loop++)
			{
				factorials[loop] = new FactorialCalculator(loop);
				Future<Integer> future = service.submit(factorials[loop]);
				futures.add(future);
			}
			for(Future future : futures) 
			{
				if(future.isDone()) 
				{
					System.out.println(future.get());
				}
				else 
				{
					System.out.print("Waiting ...");
					while(!future.isDone())
					{
						System.out.println(".");
						Thread.sleep(100);
					}
					System.out.println(future.get());
				}
			}
			service.shutdown();
		}
		catch(InterruptedException e)	
		{
			e.printStackTrace();
		}
		
	}
}
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;


public class OddsAndEvens implements Runnable
{
	private List<Integer> numbers;
	private boolean even;

	public OddsAndEvens(List<Integer> numbers, boolean even)
	{
		this.numbers = numbers;
		this.even = even;
	}
	public static void main(String [] args)
	{
		System.out.println("\r\n");
		
		List<Integer> numbers = new CopyOnWriteArrayList<Integer>(new ArrayList<Integer>(100));
		for(int i=0;i<100;i++)
		{
			numbers.add(i);	
		}
		Thread odd = new Thread(new OddsAndEvens(numbers, false));
		Thread even = new Thread(new OddsAndEvens(numbers, true));
		

		odd.start();
		even.start();
	}

	public void run()
	{
		if(even)
		{
			synchronized(numbers) 
			{
				try
				{
					for(int i=0;i<numbers.size();i=i+2)
					{
					numbers.notify();				
					Thread.sleep(500);
					System.out.println(numbers.get(i));					
					numbers.wait();
					}
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					System.out.println("\r\n");
				}
			}
				
		}
		{
			synchronized(numbers) 
			{
				try
				{
					for(int i=1;i<numbers.size();i=i+2)
					{
						numbers.wait();
						Thread.sleep(500);
						System.out.println(numbers.get(i));
						numbers.notify();
					}
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					System.out.println("\r\n");
				}
			}			
				
		}
		
	}	
}
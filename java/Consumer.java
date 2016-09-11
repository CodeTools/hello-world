import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Consumer implements Runnable
{
	private List<Integer> integers;
	private Integer multiple;

	public Consumer(List<Integer> list, Integer multiple)
	{
		integers = list;
		this.multiple = multiple;
	}

	public void run() 
	{
		if(integers != null) 
		{
			 
			{
				int count = 0;
				for(Integer integer : integers)
				{
					if(count % multiple == 0) System.out.println(integer);
					count++;
				}
				System.out.println("Sleeping for 2 sec");
			}
		}	
	}


	public static void main(String [] args) throws Exception
	{
		Thread [] pool = new Thread[10];		
		List<Integer> list = new CopyOnWriteArrayList<Integer>();		
		for(int i=0;i<1000;i++) list.add(new Integer(i));				
		for(int i=1;i<5;i++)
		{
			pool[i] = new Thread(new Consumer(list, i));
		}
		System.out.println("Sleeping for 2 sec");
		Thread.sleep(2000);
					
		for(int i=1;i<5;i++)
		{
			
			pool[i].start();						
			Thread.sleep(2000);
		}
	}
}
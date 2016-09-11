import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class CarParking 
{

	private static final Integer MAX = 11;
	private final Semaphore available = new Semaphore(MAX, true);	
	private final List<Integer> spaces = new CopyOnWriteArrayList<Integer>();
	private final boolean [] used = new boolean[MAX];
	private Integer end = -1;



	public CarParking() 
	{
		for(int i=0;i<MAX;i++)
		{
			spaces.add(-1);
		}
		for(int i=0;i<MAX;i++)
		{
			used[i] = false;
		}
		
	}



	public synchronized void capture()  throws InterruptedException
	{
		available.acquire();
		park();	
	}

	public synchronized void release()
	{
		available.release();
		dePark();
	}

 
	Integer dePark() 
	{
		Integer  counter = -1;
		for(boolean booked : used) 
		{
			counter++;
			if(booked) 
			{
				used[counter] = false;
				Integer returnValue =  spaces.get(counter);
				spaces.set(counter, -1);
				System.out.println("D->" + spaces);
				return returnValue;
			}
			else 
			{
				continue;
			}			
		}
		return null;
	}


	boolean park() 
	{
		Integer counter = -1;
		for(boolean booked : used) {	
			counter++;		
			if(!booked) 
			{
				used[counter] = true;
				spaces.set(++end, counter);
				System.out.println("P->" + spaces);
				return booked;
			}
			else 
			{

				continue;				
			}		
		}
		return false;
	}


	static class Allocator implements Runnable 
	{
		CarParking cp;
		
		Allocator(CarParking cp)
		{
			this.cp = cp;
		}
		
		public void run()
		{
			
			try
			{
				cp.capture();
			}
			catch(InterruptedException e)
			{
				System.err.println(" Something went wrong ");
			}
		}
	}



	static class Deallocator implements Runnable 
	{
		CarParking cp;
		
		Deallocator(CarParking cp)
		{
			this.cp = cp;
		}
		
		public void run()
		{
			cp.release();
			
		}
	}

	public static void main(String [] args) throws Exception
	{
		System.out.println("Car Parking");
		Scanner scanner = new Scanner(System.in);

		CarParking carParking = new CarParking();
		for(int i=0;i < 10;i++) 
		{
			new Thread(new Allocator(carParking)).start();						
		}


		for(int i=0;i < 10;i++) 
		{
			new Thread(new Deallocator(carParking)).start();						
		}		
		
	}
}
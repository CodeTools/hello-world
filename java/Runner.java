import java.util.concurrent.CountDownLatch;


/**
 *
 *  Runner class
 *
 *
 **/
public class Runner implements Runnable 
{


	private CountDownLatch startSignal;
	private CountDownLatch stopSignal;
	private boolean isDriver;


	/**
	 *
	 * Constructor
	 *
	 **/
	public Runner() 
	{
	
	}

	/**
	 *
	 * Parameterized Constructor
	 *
	 *
	 **/
	public Runner(CountDownLatch startSignal, CountDownLatch stopSignal)	
	{
		this.startSignal = startSignal;
		this.stopSignal = stopSignal;		
		isDriver = false;
	}

	/**
	 *
	 * Parameterized Constructor with control flag 
	 *
	 *
	 **/
	public Runner(boolean isDriver, CountDownLatch startSignal, CountDownLatch stopSignal)	
	{
		this.startSignal = startSignal;
		this.stopSignal = stopSignal;		
		if(isDriver)	System.out.println("Driver starting");
		this.isDriver = isDriver;
		startSignal.countDown();
		System.out.println("Driver Counting down");
	}



	/**
	 *
	 * Overriding the run method
 	 *
	 *
	 **/
	@Override
	public void run() 
	{

		try 
		{
		if(isDriver) 
			{
				System.out.println(" waiting for the workers");
				stopSignal.await();
				System.out.println(" driver Shutting down.");
			}
		else 
			{
				Thread.sleep(3000);
				System.out.println(" Caller waiting ");
				startSignal.await();
				System.out.println(" Caller counting down ");
				stopSignal.countDown();
			}
		}
		catch(Exception e) 
		{
			System.err.println("e:"+e.getMessage());
		}

	}

	public static void main(String [] args)
	{
		System.out.println(" check Runner check ");
	}


	static Runner getRunner()
	{
		return new Runner();
	}
}
import java.util.concurrent.CountDownLatch;

/**
 *
 * Main class
 *
 *
 **/
public class Main 
{
	/**
	 *
	 * Main method uses the Count Down Latch 
	 *
	 **/
	public static void main(String [] args) throws Exception
	{
		CountDownLatch drive = new CountDownLatch(1); // Drive
		CountDownLatch work = new CountDownLatch(10); // Workers
		Runner driver = new Runner(true, drive, work); // Drive
		Thread t = new Thread(driver);  //
		t.start(); // Start
		t = null;
		Runner [] workers = new Runner[10]; // An array of Runners to do the work
		for(int i=0;i<10;i++)
		{
			workers[i] = new Runner(drive, work); 
			t = new Thread(workers[i]);	
			t.start();
			t = null;
		}
	}
}
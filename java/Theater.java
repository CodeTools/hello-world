import java.util.Random;

public class Theater implements Runnable
{
	private Movie nextMovie;


	public Theater(Movie nextMovie)
	{
		this.nextMovie = nextMovie;
	}

	public void run()
	{
		Random random = new Random();
		System.out.println("Book Your tickets: ");
        	for (String title = nextMovie.release();!title.equals("DONE");title = nextMovie.release()) {
            		System.out.println("Now Showing: "+ title);
            		try 
			{
                		Thread.sleep(random.nextInt(52 * 100));
            		} 
			catch (InterruptedException e) 
			{
				System.err.println(e.getMessage());
			}
        	}
	}
	
}
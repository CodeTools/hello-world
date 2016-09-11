import java.util.Random;

public class MovieStudio implements Runnable
{
	
	private Movie nextMovie;


	public MovieStudio(Movie nextMovie)
	{
		this.nextMovie = nextMovie;
	}

	public void run()
	{
		String [] nextTitles = {
		"Iron Man",
		"The Incredible Hulk",
		"Iron Man Two",
		"Thor",
		"Captain America : First Avenger",
		"Marvels Avengers Assemble",
		"Iron Man Three",
		"Captain America : The Winter Soldier",
		"Thor 2: The Dark World",
		"Avengers Two : The Age Of Ultron",
		"Ant-Man",
		"Captain America : Civil War"
		};		

		Random weeks = new Random();





		for (int i = 0;i < nextTitles.length;i++) 
		{
            		nextMovie.queue(nextTitles[i]);			
		        try 
			{
                		Thread.sleep(weeks.nextInt(52 * 100));
            		}
			catch (InterruptedException e) 
			{	
				System.err.println(e);	
			}
        	}
	        nextMovie.queue("DONE");
	}
	
}
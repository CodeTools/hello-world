public class Critic
{
	public static void main(String [] args)
	{
		Movie movie = new Movie();
		System.out.println(" watch New Movies \r\n");
		(new Thread(new MovieStudio(movie))).start();
		(new Thread(new Theater(movie))).start();
	}
}
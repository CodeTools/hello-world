public class Movie
{
	private String title;
	private boolean released;


	public Movie() 
	{
		released = false;
		title = null;
	}



	public synchronized String release()
	{

		while(!released) // if not released
		{
			
			try
			{
				wait(); // wait for a signal that it has been released
			}	
			catch(InterruptedException e)
			{
				System.err.println(e.getMessage());
			}			
		}
		released = false; // change status
		
		notifyAll();		
		return title;
	}



	public synchronized void queue(String title)
	{
		
		while(released) // check if theatres are empty .. 
		{
			
			try
			{
				wait(); //if not wait for a signal that a slot is empty
			}	
			catch(InterruptedException e)
			{
				System.err.println(e.getMessage());
			}				
		}
		released = true; // change status                
		this.title = title;
        	notifyAll();	
	}
	
}
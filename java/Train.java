public class Train
{
	public static void main(String [] args)
	{
		System.out.println("\r\n");
		Train.Signal signal = new Signal(false);
		new Thread(new Engine(signal)).start();
		new Thread(new Train.GaurdBox(signal)).start();
		
		
		
	}


	static class Signal
	{
		boolean ready;

		Signal(boolean ready)
		{
			this.ready = ready;
		}

		boolean isReady() 
		{
			return ready;
		}

		void setReady(boolean ready)
		{
			this.ready = ready;
		}
	}

	static class GaurdBox implements Runnable
	{
		Signal signal;
		GaurdBox(Signal signal)
		{
			this.signal = signal;
		}


		public void run()
		{
			synchronized(signal)
			{
				try 
				{
					System.out.println(" Check Out Station Signal ");
					Thread.sleep(1000);									
					signal.notify();		
					System.out.println(" Wave Green Flag");	
					
				}
				catch(InterruptedException e)
				{
					System.err.println(e.getMessage());
				}
			}
		}
		
	}

	static class Engine implements Runnable 
	{
		Signal signal;
		Engine(Signal signal)
		{
			this.signal = signal;
		}	
		
		public void run()
		{
			synchronized(signal)
			{
				try 
				{
					System.out.println(" Wait for Flag from Gaurd");					
					signal.wait();	
					System.out.println(" Start Engine ");
				}
				catch(InterruptedException e)
				{
				}
			}
		}
	}
}




	
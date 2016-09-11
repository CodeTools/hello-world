public class OddsAndEvens3
{
	public static void main(String [] args)
	{
		System.out.println("\r\n");
		OddsAndEvens3.FishPlate fishPlate = new FishPlate(10);
		(new Thread(new Odd(fishPlate))).start();
		(new Thread(new Even(fishPlate))).start();
	}



	static class FishPlate
	{
		Integer count;
		Integer original;
		FishPlate(Integer counte) {count = counte;original=counte;}
		
		Integer getCount() {return count;}
		Integer getOriginal() {return original;}
		void setCount(Integer counte) {count=counte;}


		void downCount() {count--;}
		boolean isEven() {return count%2==0;}
	}

	static class Odd implements Runnable
	{
		FishPlate fishPlate;
		Odd(FishPlate plate) {fishPlate = plate;}

		public void run()
		{
			try
			{
				for(;fishPlate.getCount() > 0;fishPlate.downCount())
				{
					synchronized(fishPlate)
					{
						fishPlate.wait();
						if(!fishPlate.isEven()) 
						{
							try
							{
								Thread.sleep(1000);
							}
							catch(Exception e)
							{}			



							System.out.println("" + fishPlate.getCount());
						}
						fishPlate.notifyAll();
					}										
				}
				synchronized(fishPlate)
				{
						fishPlate.notifyAll();					
				}
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
			
		}
	}


	static class Even implements Runnable	
	{
		FishPlate fishPlate;
		Even(FishPlate plate) {fishPlate = plate;}

		public void run()
		{
			try
			{
				for(;fishPlate.getCount() > 0;)
				{
					synchronized(fishPlate)
					{
						fishPlate.notifyAll();
						if(fishPlate.isEven()) 
						{
							try
							{
								Thread.sleep(1000);
							}
							catch(Exception e)
							{}



							System.out.println("" + fishPlate.getCount());
						}
						fishPlate.wait();
					}
					
				}
				synchronized(fishPlate)
				{
						fishPlate.notifyAll();					
				}
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
			
		}
		
	}
}
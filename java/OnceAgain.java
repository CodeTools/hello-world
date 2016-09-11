public class OnceAgain 
{

	private static Batman bruceWayne = Batman.batcave();
	
	public static void main(String [] args)
	{
		System.out.println("\r\n Batman has:\r\n");
		for(String things : bruceWayne.has()) System.out.println(things);
		System.out.println("\r\n Batman knows:\r\n");
		for(String stuff : bruceWayne.knows()) System.out.println(stuff);
		
	}



	private static class Batman 
	{

		public static Batman batcave()
		{
			return new Batman();
		}

		private Batman()
		{
			
		}


		

		String [] knows() 
		{
			return new String []
			{
				"Martial arts",
				"Detection",
				"Decoy",
				"Invention"
			};
		}

		String [] has()
		{
			return new String []
			{
				"142 Billion dollars",
				"Batmobile",
				"Killer Physique"
			};
		}	
	
	
	
	};


}
public class Primaries
{

	private static Primaries staticPrimaries = new Primaries();
	
	public static void main(String [] args)
	{
		System.out.println("Primaries\r\n");
		Batman batman = staticPrimaries.new Batman();
		System.out.println(batman);		
		System.out.println(batman.whenIgoHunting());
		System.out.println(batman.whereIReturn());
	}



	class Batman 
	{
		Batcave aBatcave;
		Batmobile aBatmobile;


		Batman() 
		{
			aBatcave = new Batcave();
			aBatmobile  = new Batmobile();
		}


		Batcave whereIReturn() {  return aBatcave; }

		Batmobile whenIgoHunting() { return aBatmobile; }


		public String toString() 
		{
			return "a Dark Knight";
		}
	}
		

	class Batcave
	{
		Batcave() {}
		public String toString()
		{
			return "return home";
		}
	}
	
	class Batmobile
	{


		Batmobile() {}

		public String toString()
		{
			return "Go Hunting";
		}
	}

}
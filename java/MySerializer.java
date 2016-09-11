public class MySerializer implements java.io.Serializable
{

	private short age;
	private double salary;
	private boolean permanent;
	private String name;
	private java.util.Date doj;


	public MySerializer() {}
	

	public static void main(String [] args)
	{
		System.out.println("MySerializer");
		call();
	}

	private static java.util.Calendar loadCalendar()
	{
		return new java.util.GregorianCalendar();
	}

	private static java.util.Calendar fluxCalendar(int year, int month, int dayOfMonth, java.util.Calendar loadedCal)
	{
		if(loadedCal == null) return null;
		else 
		{
			loadedCal.set(year, month, dayOfMonth);
			return loadedCal;
		}
		
	}


	private static void call()
	{
		MySerializer ms = getInstance();
		write(ms);
		ms = null;
		ms = (MySerializer) read();
		System.out.println(" age             " + ms.age);
		System.out.println(" salary          " + ms.salary);
		System.out.println(" permanent       " + ms.permanent);	
		System.out.println(" name            " + ms.name);
		System.out.println(" Date Of Joining " + ms.doj);
	}


	public static MySerializer getInstance() {
		MySerializer ms = new MySerializer();
		ms.age = 34;
		ms.salary = 1324000.00;
		ms.permanent = true;
		ms.name = "Sanjay Ghosh";
		ms.doj = fluxCalendar(2014, 1, 3, loadCalendar()).getTime();		
		return ms;
	}


	public static void write(Object object)
	{
		try
			{
				java.io.FileOutputStream outputFile = new java.io.FileOutputStream("MyObject.ser");
				java.io.ObjectOutputStream output = new java.io.ObjectOutputStream(outputFile);
				output.writeObject(object);
				System.out.println(" object written to " + "MyObject.ser");
				output.close();
				outputFile.close();
			}
	
		catch(java.io.IOException e)
			{
				System.err.println(" something went wrong ");
				e.printStackTrace();
			}

	}

	public static Object read()
	{
		try 
			{
				java.io.FileInputStream inputFile = new java.io.FileInputStream("MyObject.ser");
				java.io.ObjectInputStream input = new java.io.ObjectInputStream(inputFile);		
				System.out.println(" reading object from " + "MyObject.ser");
				Object object = input.readObject();
				input.close();
				inputFile.close();
				return object;
			}

		catch(Exception e)
			{
				System.err.println(" something went wrong ");
				e.printStackTrace();
				return null;
			}
	}


	





	static class Jumper implements java.io.Serializable
	{
		
	}
}
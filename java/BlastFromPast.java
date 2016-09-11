import java.io.File;


public class BlastFromPast {
	public static void main(String [] args)
	{
		if(args == null || args.length < 2) {
			usage(args);
		}
		else {
			String dir = args[0];
			String op  = args[1];

			System.out.println(" Directory to be searched " + dir);
			System.out.println(" Operation " + op);


			if("S".equals(op) || "s".equals(op)) {
				String list [] = list(dir);
				if(list != null) for(String file : list) System.out.println(file);
			}


			

		}	
	}

	public static String [] list(String dir) {
		try {
			if(new File(dir).isFile()) {
				System.out.println(" Unable to list or search a File ");
			}
			else return new File(dir).list();
		}		
		catch(Exception e) {
			System.err.println(" Check whether the dir exists ");
		}

		return null;
	}


	public static void usage(String [] args) {
		System.out.println("Insufficient Arguments!!!");
		if(args != null) {
			System.out.println(" args length " + args.length);
		}
	}

}
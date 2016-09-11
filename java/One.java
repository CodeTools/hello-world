import java.io.File;

public class One {


	private static Integer FILES = 0;
	private static Integer DIRS = 0;

	public static void main(String [] args) throws Exception
	{
		
		long start = System.currentTimeMillis();
		File file = new File(".");
		File [] roots = file.listRoots();
		for(File root : roots)
		{
			System.out.println("root="+root);			
			list(root);
			System.out.println("");			
			root = null;
		}

		System.out.println(" Total Number of Files " + FILES);		
		long end = System.currentTimeMillis();
		System.out.println(" Total Time Taken " + (end - start) + " milis ");		
	}



	public static void list(File dir) throws Exception
	{
		if(dir != null)
		{
			if(dir.isFile())
			{
				System.out.println("File :" + dir.getAbsolutePath());
				dir = null;
				FILES++;
			}
			else if(dir.isDirectory())
			{
				File [] subFiles = dir.listFiles();
				if(subFiles != null)
				{
					for(File file : subFiles) 
						{
							list(file);
							file = null;
						} 
					System.out.println("");
				}
				subFiles = null;	
			}
		}	
	}
}
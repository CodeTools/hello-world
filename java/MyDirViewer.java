import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import java.io.File;


public class MyDirViewer 
{

	public static void main(String [] args) 
	{
		System.out.println("\r\nMyDirViewer");	
	}


	public static List<File> get(String dir) 
	{
		return Arrays.asList((new File(dir)).list(), new File[0]);
	}
}
import static java.lang.System.out;
import static java.lang.System.exit;

/**
 *
 * Toy Program to use permutations
 *
 *
 **/
public class Permutations   
{

	public static void main(String [] args)
	{
		if(args == null || args.length < 1 || args.length > 1)
		{
			out.println("Usage: java -cp . Permuations 1234 ");
			exit(-1);
		}
		String str = args[0];
		if(str == null || str.length() == 0 || str.length() > 9) 
		{
			out.println("\n String is too long or empty");
			exit(-1);
		}
		else
		{
			permute("", str);
		}
	}


	static void permute(String dst, String src)
	{
		if(src == null || src.length() == 0)
		{
			out.println(dst);
		}
		else
		{
			for(int index=0;index<src.length();index++)
			{
				permute(dst + src.charAt(index), src.substring(0, index).concat(src.substring(index+1)));
			}
		}
	}
}
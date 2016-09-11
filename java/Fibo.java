import java.math.BigInteger;

public class Fibo
{

	public static BigInteger THOUSAND = BigInteger.TEN.multiply(BigInteger.TEN).multiply(BigInteger.TEN);
	public static BigInteger MILLION = THOUSAND.multiply(THOUSAND);
	public static BigInteger BILLION = THOUSAND.multiply(THOUSAND).multiply(THOUSAND);
        public static BigInteger TRILLION = MILLION.multiply(MILLION);
	
	public static void main(String [] args)
	{
		System.out.println("Fibo");
		long start = System.currentTimeMillis();
		getFibonacci().fibo(new BigInteger("1000000000"));
		long end = System.currentTimeMillis();
		System.out.println(" Time taken " + (end - start) + " mili secs ");		
	}

	public static Fibo getFibonacci()
	{
		return new Fibo();
	}

	private Fibo() {}

	public void fibo(BigInteger last)
	{
		if(BILLION.compareTo(last) < 0) throw new IllegalArgumentException("");
		else 
		{
			System.out.println("printing fibo");
 			BigInteger first = BigInteger.ONE;
                        BigInteger second = BigInteger.ONE;
			BigInteger current = first.add(second) ;
			System.out.println(first);
			System.out.println(second);
			while(current.compareTo(last) < 0)
			{
				System.out.println(current);			
				first = second;
				second = current;
				current = first.add(second);				
			}
		}
	}



	public void fibo(int last)
	{		
		if(last > 1000000) throw new IllegalArgumentException("");
		else 
		{
			System.out.println("printing fibo");
 			int first = 1;
                        int second = 1;
			int current = first  + second;
			System.out.println(first);
			System.out.println(second);
			while(current < last)
			{
				System.out.println(current);			
				first = second;
				second = current;
				current = first + second;				
			}
			
		}
	}
}
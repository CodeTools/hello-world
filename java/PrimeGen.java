import java.util.List;
import java.util.ArrayList;

import java.math.BigInteger;


public class PrimeGen 
{


	public static List<BigInteger> collect(BigInteger limit) 
	{
		List<BigInteger> primeNumbers = new ArrayList<BigInteger>();
		List<BigInteger> temporary = new ArrayList<BigInteger>();

		// Add basic Prime Numbers 
		primeNumbers.add(BigInteger.valueOf(2));
		primeNumbers.add(BigInteger.valueOf(3));
		primeNumbers.add(BigInteger.valueOf(5));
		primeNumbers.add(BigInteger.valueOf(7));
		primeNumbers.add(BigInteger.valueOf(11));

		// Add others
		BigInteger count = BigInteger.valueOf(12);
		BigInteger hundred = BigInteger.valueOf(100);

		while(count.compareTo(hundred) <= 0)
		{
			count = count.add(BigInteger.ONE);
			boolean isPrime = true;
			for(BigInteger prime : primeNumbers)
			{
				if(count.mod(prime).equals(BigInteger.ZERO)) 
				{
					isPrime = false;
					break;
				}				
			}
			if(isPrime) temporary.add(count);
						
		}
		primeNumbers.addAll(temporary);
		return primeNumbers;
	}

	public static void main(String [] args)
	{
		System.out.println("\r\n Prime Gen");
		System.out.println(collect(BigInteger.valueOf(100)));
	}
}
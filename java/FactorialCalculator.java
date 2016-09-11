import java.util.concurrent.Callable;
import java.lang.Integer;

public class FactorialCalculator implements Callable<Integer>
{
	private Integer seed;


	FactorialCalculator(Integer seed)
	{
		this.seed = seed;
	}

	public Integer call() throws RuntimeException, InterruptedException
	{
		if(seed.intValue() < 1) return 1;
		else {
			int counter = seed;
			int factorial = 1;
			while(seed > 0) 
			{
				factorial = factorial * seed;
				counter = counter - 1;
				seed = seed - 1;
				Thread.sleep(seed * 100);									
			}
			return new Integer(factorial);
		}
	}
}
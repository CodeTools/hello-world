import java.util.Scanner;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;


public class StandingOvation 
{

	private static Scanner scanner = new Scanner(System.in);
	private static PrintStream stdOut = System.out;

	public static void main(String args[]) 
	{	
	Integer Testcases = scanner.nextInt();	
		for(int _case = 1 ; _case <= Testcases;_case++) {
			Integer shyNess = scanner.nextInt();
			String audience = scanner.next();
			Integer friends = countFriends(shyNess, audience);
			print("" + friends, _case);
		}

	}


	private static void print(String s, Integer i) 
	{
		stdOut.println("Case #" + i + ": " + s);
	}

	private static Integer getInteger(char c) 
	{
		Integer i = -1;
		if(c == '1') {
			i = 1;
		} else if(c == '2') {
			i = 2;
		} else if(c == '3') {
			i = 3;
		} else if(c == '4') {
			i = 4;
		} else if(c == '5') {
			i = 5;
		} else if(c == '6') {
			i = 6;
		} else if(c == '7') {
			i = 7;
		} else if(c == '8') {
			i = 8;
		} else if(c == '9') {
			i = 9;
		} else if(c == '0') {
			i = 0;
		} 
		return i;
	}


	private static Integer countFriends(Integer shyNess, String audience) 
	{
		Integer friends = 0;
		Integer [] array = new Integer[audience.length()];
		for(int index=0;index<array.length;index++) 
		{
			array[index] = getInteger(audience.charAt(index));			
		}
		List<Integer> list = new ArrayList<Integer>();
		Integer sum = 0;// People who have stood up !!!
		for(int index=0;index < array.length;index++)	
		{
			//System.out.println(" array [" + index + "] " + array[index]);		
			//System.out.println(" sum " + sum);
			if(array[index] != 0) { // if there are people at this shyness level
				if(sum >= index) { // if there are already 'index' people standing and clapping
					//System.out.println("---------->>>>clap ");
				}
				else {
					//System.out.println("---------->>>>Add Friends " + (index - sum));
					friends = friends + (index - sum);
					sum = sum + (index - sum);
				}
			}
			sum = sum + array[index];
		}
		return friends;
	}
}
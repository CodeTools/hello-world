import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
	StringBuilder builder = new StringBuilder("");
	while(n > 0) {
		builder.append(n%2);
		n=n/2;
	}
	System.out.println(countOnes(reverse(builder.toString())));
    }


    public static String reverse(String str){	
	StringBuilder builder = new StringBuilder("");
	char array [] = str.toCharArray();
	for(int len=array.length -1;len>-1;len--) builder.append(array[len]); 
	return builder.toString();
    }


    private static Integer countOnes(String str) {
	Integer ones = 0;
	StringTokenizer t = new StringTokenizer(str, "0");
	Integer max = -1;
	while(t.hasMoreTokens()) {
		Integer current = (t.nextToken().length());
		if(current > max) max = current;
	}

	return max;
    }
}

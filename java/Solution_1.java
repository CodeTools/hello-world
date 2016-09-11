import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        Integer testCases = scanner.nextInt();
        Integer T = testCases;
        while(T > 0){
            String s = scanner.next();
            boolean isByte = true;
            boolean isShort = true;
            boolean isInt = true;
            boolean isLong = true;
            try {
                byte b1 = Byte.parseByte(s);
            }
            catch(Exception e) {
                isByte = false;
            }
            try {
                short b1 = Short.parseShort(s);
            }
            catch(Exception e) {
                isShort = false;
            }try {
                int b1 = Integer.parseInt(s);
            }
            catch(Exception e) {
                isInt = false;
            }try {
                long b1 = Long.parseLong(s);
            }
            catch(Exception e) {
                isLong = false;
            }
	    if(!(!isByte && !isShort && !isInt && !isLong)) {
	    	System.out.println(s + " can be fitted in:");
	    }
	    if(isByte) {
		System.out.println("* byte");
	    } 
	    if(isShort) {
		System.out.println("* short");
	    } 
	    if(isInt) {
		System.out.println("* int");
	    }  
	    if(isLong) {
		System.out.println("* long");
	    } 
	    if(!isByte && !isShort && !isInt && !isLong) {
		System.out.println(s + " can't be fitted anywhere.");
	    }	 
            T--;
        }
    }
}
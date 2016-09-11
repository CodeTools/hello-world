import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            String B=sc.next();
	
            String X = titleCase(A) + " " + titleCase(B);
            System.out.println((A.length() + B.length()));
            System.out.println(asInDictionary(A, B));
            System.out.println(X);
            

    }

    private static String titleCase(String s) 
    {
	return s.substring(0, 1).toUpperCase().concat(s.substring(1, s.length()).toLowerCase());
    }


    private static String asInDictionary(String a, String b) 
    {
	return a.compareTo(b) > 0 ? "YES" : "NO";
    }
}
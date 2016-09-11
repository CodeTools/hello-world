import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	int arr [][] = new int[6][6];
	for(int outer=0;outer<6;outer++) {
		for(int inner=0;inner<6;inner++) {
			arr[outer][inner] = in.nextInt();
			
		}
	}
	System.out.println(greatestHourGlassSB(arr, arr.length));
        
    }


    private static Integer greatestHourGlassSB(int array [][], int length) {
	Integer max = Integer.MIN_VALUE;
	Integer current = 0;
	for(int outer = 0;outer < 4;outer++ ) {
		for(int inner = 0; inner < 4 ; inner++) {
			current = sumHourGlass(array, outer, inner);			
			if(max < current) max = current;
			
		}
	}
	
	return max;
    }

    private static Integer sumHourGlass(int array [][], int startX, int startY) {	
	return (array[startX][startY] + array[startX][startY + 1] + array[startX][startY + 2] + array[startX + 1][startY + 1] +
		array[startX + 2][startY] + array[startX + 2][startY + 1] + array[startX + 2][startY + 2] );
    }


    
}

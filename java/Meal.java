import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Meal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();
      
        // Write your calculation code here.
        double tip = mealCost *  (tipPercent / 100.00);
        double tax = mealCost *  (taxPercent / 100.00);
        double intermediateCost = mealCost + tip + tax;
      
        // cast the result of the rounding operation to an int and save it as totalCost 
        int totalCost = (int) Math.round(intermediateCost);
      
        // Print your result
	//System.out.println(mealCost);
	//System.out.println("tip = " + (tipPercent / 100.00));
	//System.out.println(" actual tip = " + (mealCost * (tipPercent / 100.00)));
	//System.out.println(tip);
	//System.out.println("tax = " + (taxPercent / 100.00));
	//System.out.println(" actual tax = " + (mealCost * (taxPercent / 100.00)));
	//System.out.println(tax);
        System.out.println(String.format("The total meal cost is %d dollars.", totalCost));
    }
}

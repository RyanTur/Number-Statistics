/*
 * Author: Ryan Turlington
 * Project #: 1
 * Title: Number Statistics 
 * Due Date 10/7/2022
 * 
 * Reads in a list of numbers and calculates statistics based on users selection
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Prompts the user to enter a list of integers and runs various calculations 
 */
public class ProjectProgram {

	public static ArrayList<Integer> integerList() 
	{
		//reads in the list 
		ArrayList<Integer> userInput = new ArrayList<>();
		System.out.println("Enter List of Integers Separated by Spaces: ");
		Scanner scnr = new Scanner(System.in);
		String line = scnr.nextLine();
		String[] tokens = line.split(" ");
		
		for(int i = 0; i < tokens.length; i++)
			userInput.add(Integer.parseInt(tokens[i]));
		

		/*while (scnr.hasNextInt()) 
		{
			userInput.add(scnr.nextInt());
		}*/

		return userInput;

	}//end integerList

	public static void numCalcs(ArrayList<Integer> userList)
	{
		//variable declaration 
		int length = userList.size();
		Collections.sort(userList); //sorting the list 
		int range = 0;

		System.out.println("Min: " + userList.get(0));//min

		System.out.println("Max: " + userList.get(length - 1));//max

		System.out.println("Count: " + length);//length

		range = userList.get(length -1) - userList.get(0);//calculating range
		System.out.println("Range: " + range);
	}//end numClacs

	public static double medianMethod(ArrayList<Integer> userList)
	{
		//variable declaration 
		double result = 0;
		int medianLocation = 0;
		int length = userList.size();

		//calculating the median 
		if(length %2 == 0)
		{
			medianLocation = length / 2;
			result = (userList.get(medianLocation) + userList.get(medianLocation - 1));
			result /= 2;

		}
		else
		{
			medianLocation = (length - 1) / 2;
			result = userList.get(medianLocation);
		}

		return result;
	}//end medianMethod

	public static double meanMethod(ArrayList<Integer> userList) 
	{
		//variable declaration 
		double result = 0;
		double sum = 0;
		int length = userList.size();

		//calculating the mean 
		for (int i = 0; i < length; i++)
		{
			sum += userList.get(i);
			result = sum / length;
		}

		return result;
	}//end meanMethod

	public static void modeMethod(ArrayList<Integer> userList) 
	{
		//variable declaration 
		int result = 0;
		int count = 0;

		//reading in each number 
		for (int i = 0;i < userList.size(); i++)
		{
			int tempValue1 = userList.get(i);
			int tempCount = 1;

			//comparing if number is the same  
			for(int j = 0; j < userList.size(); j++)
			{
				int tempValue2 = userList.get(j);

				if( tempValue1 == tempValue2)
					tempCount++; // counting number of the same

				if( tempCount > count)
				{
					count = tempCount;
					result = tempValue1;
				}
			}
		}
		if (count == 2)
			System.out.println("Mode: No Mode");
		else
			System.out.println("Mode: " + result);
	}//modeMethod

	public static double varianceMethod(ArrayList<Integer> userList, double mean) 
	{
		//variable declaration 
		double result = 0;
		int length = userList.size();
		double holder = 0;

		for (int i = 0; i < length; i++)
			holder += Math.pow(userList.get(i) - mean, 2);

		result = holder / length;

		return result;
	}//end varianceMethod

	public static double deviationMethod(double variance) 
	{
		double result = Math.sqrt(variance);

		return result;
	}//end deviationMethod

	public static void sortingMethod(ArrayList<Integer> userList)
	{
		Collections.sort(userList);
		System.out.println(Arrays.toString(userList.toArray()));
	}//end sorting method

	public static void evenAndOddCount(ArrayList<Integer> userList)
	{
		//variable declaration 
		int length = userList.size();
		int evenCount = 0;
		int oddCount = 0;

		for(int i = 0; i < length; i++)
		{
			if(userList.get(i) %2 == 0)
				evenCount++;
			else
				oddCount++;
		}
		System.out.println("Number Even: " + evenCount);
		System.out.println("Number Odd: " + oddCount);
	}//end evenAndOddCount

	public static int primeCount(ArrayList<Integer> userList)
	{
		//variable declaration 
		int count = 0;

		//counting each prime number
		for(int i : userList)
		{
			if (primeCheckMethod(i))
				count++;
		}
		return count;
	}

	public static boolean primeCheckMethod(int n) 
	{
		//checking if number is prime 
		if (n <= 1)
			return false;

		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for(int j = 5; j * j <= n; j = j + 6)
		{
			if (n % j == 0 || n % (j + 2) == 0)
				return false;
		}
		return true;
	}//end primeCheckMethod

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		ArrayList<Integer> userList = integerList();
		System.out.println();
		//System.out.println(Arrays.toString(userList.toArray()));

		// Prompt a menu for the user 
		boolean flag = true; 

		do {

			System.out.println("Please make a selection:");
			System.out.println("1) Display List Statistics");
			System.out.println("2) Display List Ordered");
			System.out.println("3) Number of Odd/Even");
			System.out.println("4) Check for Prime Numbers");
			System.out.println("5) Enter New List");
			System.out.println("exit) Quit Program");

			String input = scnr.nextLine();

			switch(input) {

			case "1":
				//running basic statistics 
				numCalcs(userList);

				//calculating the median
				double median = medianMethod(userList);
				System.out.println("Median: " + median);

				//calculating the mean 
				double mean = meanMethod(userList);
				System.out.print("Mean: ");
				System.out.printf("%1.2f", mean);
				System.out.println();

				//finding the mode
				modeMethod(userList);

				//calculating the variance 
				double variance = varianceMethod(userList, mean);
				System.out.print("Variance: ");
				System.out.printf("%1.2f", variance);
				System.out.println();

				//calculating the standard deviation 
				double deviation = deviationMethod(variance);
				System.out.print("Standard Deviation: ");
				System.out.printf("%1.2f", deviation);
				System.out.println();

				System.out.println();
				break;

				//sorting the list 
			case "2":
				sortingMethod(userList);
				System.out.println();
				break;

				//calculate number of even and odd
			case "3":
				evenAndOddCount(userList);
				System.out.println();
				break;

				//counting number of prime numbers 
			case "4":
				int primeNums = primeCount(userList);
				System.out.println("Number of Prime in list: " + primeNums);
				System.out.println();
				break;

				//enter new list prompt
			case "5":
				userList = integerList();
				System.out.println();
				break;

				//exit
			case "exit":
				System.out.println("Program is Exiting");
				flag = false;
				break;
			default:
				System.out.println("Please Enter Valid Secletion");
				System.out.println();
			}

		}while(flag);



	}//end main

}//end class 
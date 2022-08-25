import java.util.*;
import java.io.*;

class Factorial
{
	/*public static void main(String[] args)
	{
		//long startTime = System.nanoTime();
		int facVal = 10;
		int fibVal = 10;
		long n = calcNFactorial(facVal);
		System.out.println("iterative factorial = "+ n);
		n = calcNFactorialRecursive(facVal);
		System.out.println("recursive factorial = "+ n);
		int m = fibIterative(fibVal);
		System.out.println("iterative fib = "+ m);
		m = fibRecursive(fibVal);
		System.out.println("recusive fib = "+ m);
	}*/

	public static long calcNFactorial(int n){
		//long nFactorial = 1;
		if(n<0)
		{
			throw new IllegalArgumentException("Import_must_not_be_negative");
		}
		else
		{
			return calcNFactorialRecursive(n);
		}


		/*for(int ii = n;ii >= 2; ii--)
		{
			nFactorial *= ii;
		}
		return nFactorial;*/
	}
	public static long calcNFactorialRecursive(int n)
	{
		long factorial = 1;
		if(n == 0)
		{
			factorial =  1;
		}
		else
		{
			factorial =  n* calcNFactorialRecursive(n-1);
		}
		return factorial;
	}
	public static int fibIterative(int n)
	{
		int fibVal = 0;
		int currVal = 1;
		int lastVal = 0;

		if(n<0){
			throw new IllegalArgumentException("Import_must_not_be_negative");
		}
		if(n==0)
		{
			fibVal = 0;
		}
		else if(n==1)
		{
			fibVal = 1;
		}
		else
		{
			for(int ii = 1; ii < n; ii++)
			{
				fibVal = currVal + lastVal;
				lastVal = currVal;
				currVal = fibVal;
			}
		}
		return fibVal;
	}
	public static int fibRecursive(int n)
	{
		int fibVal = 0;

		if(n==0)
		{
			fibVal = 0;
		}
		else if(n==1)
		{
			fibVal = 1;
		}
		else
		{
			fibVal = fibRecursive(n-1) + fibRecursive(n-2);
		}
		return fibVal;
	}

}

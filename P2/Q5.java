import java.util.*;
import java.io.*;

class Q5
{
	public static void main(String[] args)
	{
		towers(3,1,3);
	}

	public static void towers(int n, int src, int dest)
	{
		if(n==1)
		{
			moveDisk(n, src,dest);
		}
		else if (n<=0){
			throw new IllegalArgumentException("Cannot have zero or less disks");
		}
		else
		{
			int tmp = 6 - src - dest;
			towers(n-1,src,tmp);
			moveDisk(n, src,dest);
			towers(n-1,tmp,dest);
		}
	}
	public static void moveDisk(int n, int src, int dest)
	{
		for(int i = 3; i > n; i--){
			System.out.print("\t");
		}
		System.out.println("Moving disk from peg " + src + " to peg " + dest);
	}
}

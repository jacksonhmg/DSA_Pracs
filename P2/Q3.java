import java.util.*;
import java.io.*;

class Q3
{
	public static void main(String[] args)
	{
		int num = 10;
		int base = 2;
		String n = convert(num,base);
		System.out.println(num + " of base " + base + " = " + n);
	}
	public static String convert(int num, int base)
	{
		if(num == 0)
		{
			return "";
		}
		else if(base < 0){
			throw new IllegalArgumentException("Base cannot be negative");
		}
		else
		{
			return convert(num / base, base) + (num % base);
		}
	}

}

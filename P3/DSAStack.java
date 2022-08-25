public class DSAStack
{
	private Object[] stack;
	private int count;
	private int DEFAULT_CAPACITY = 5;
	
	public DSAStack()
	{
		stack = new Object[DEFAULT_CAPACITY];
		/*for(int i = 0; i < stack.length; i++)
		{
			stack[i] = i;
		}*/
		count = 0;
	}

	public DSAStack(int maxCapacity)
	{
		stack = new Object[maxCapacity];
		/*for(int i = 0; i < stack.length; i++)
		{
			stack[i] = i;
		}*/
		count = 0;
	}

	public int getCount()
	{
		return count;
	}

	public boolean isEmpty()
	{
		if(count == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isFull()
	{
		if(count == stack.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void push(Object value)
	{
		if(isFull())
		{
			throw new IllegalArgumentException("Stack is already full");
		}
		else
		{
			stack[count] = value;
			count += 1;
		}
	}

	public Object pop()
	{
		Object topVal =  top();
		count -= 1;
		return topVal;
	}

	public Object top()
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("Stack is empty");
		}
		else
		{
			return stack[count-1];
		}
	}


	public void display() {
		/* Function to display status of Circular Queue */
		int i;
		if (isEmpty()) {
		  System.out.println("Empty Queue");
		} else {
		  System.out.print("Items -> ");
		  for (i = 0; i < count; i++)
			System.out.print(stack[i] + " ");
		}
	  }



}

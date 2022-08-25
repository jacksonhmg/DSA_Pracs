public class DSAQueue
{
	private Object[] queue;
	private int count;
	private int DEFAULT_CAPACITY = 5;
	private int front = 0;
	private int rear = -1;

	public DSAQueue()
	{
		queue = new Object[DEFAULT_CAPACITY];
		/*for(int i = 0; i < queue.length; i++)
		{
			queue[i] = i;
		}*/
		count = 0;
	}

	public DSAQueue(int maxCapacity)
	{
		queue = new Object[maxCapacity];
		/*for(int i = 0; i < queue.length; i++)
		{
			queue[i] = i;
		}*/
		count = 0;
	}

	public int getCount()
	{
		return count;
	}

	public boolean isEmpty()
	{
		if(count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isFull()
	{
		if(count == queue.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void enqueue(Object value)
	{
		if(isFull())
		{
			throw new IllegalArgumentException("Stack is already full");
		}
		else
		{
			rear = (rear + 1) % queue.length;
			queue[count] = value;
			count += 1;
		}
	}

	public Object dequeue()
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("Stack is empty");
		}
		Object x = queue[front];
		System.out.println("Removing " + x);
		front = (front + 1) % queue.length;
	       	count -= 1;
		return x;	
	}

	public Object peek()
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("Stack is empty");
		}
		else
		{
			return queue[front];
		}
	}
}

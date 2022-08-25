import java.util.*;

public class DSALinkedList implements Iterable
{
	

	public Iterator iterator()
	{
		return new MyLinkedListIterator(this);
	}

	private class DSALinkedListIterator implements Iterator
	{
		private DSAListNode iterNext;
		
		public DSALinkedListIterator(DSALinkedList theList)
		{
			iterNext = theList.head;
		}

		public boolean hasNext()
		{
			return (iterNext != null);
		}

		public Object next()
		{
			Object value;
			if (iterNext == null)
			{
				value = null;
			}
			else
			{
				value = iterNext.getValue();
				iterNext = iterNext.getNext();
			}
		return value;

		}

		public void remove()
		{
			throw new UnsupportedOperationException("Not supported");
		}
	}	
		



	private DSAListNode head;

	public DSALinkedList()
	{
		head = null;
	}

	public void insertFirst(Object newValue)
	{
		DSAListNode newNd = new DSAListNode(newValue);
		if(isEmpty())
		{
			head = newNd;
		}
		else
		{
			newNd.setNext(head);
			head = newNd;
		}
	}

	public void insertLast(Object newValue)
	{
		DSAListNode newNd = new DSAListNode(newValue);
		if(isEmpty())
		{
			head = newNd;
		}
		else
		{
			DSAListNode currNd = head;
			while(currNd.getNext() != null)
			{
				currNd = currNd.getNext();
			}
			currNd.setNext(newNd);
		}

	}

	public boolean isEmpty()
	{
		boolean empty;
		if(head == null)
		{
			empty = true;
		}
		else
		{
			empty = false;
		}
		return empty;
	}

	public Object peekFirst()
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("NAH!");
		}
		else
		{
			return head.getValue();
		}
	}

	public Object peekLast()
	{
		Object nodeValue;
		if(isEmpty())
		{
			throw new IllegalArgumentException("NAH!");
		}
		else
		{
			DSAListNode currNd = head;
			while(currNd.getNext() != null)
			{
				currNd = currNd.getNext();
			}
			nodeValue = currNd.getValue();
		}
		return nodeValue;
	}

	public Object removeFirst()
	{
		Object nodeValue;
		if(isEmpty())
		{
			throw new IllegalArgumentException("NAH!");
		}
		else
		{
			nodeValue = head.getValue();
			head = head.getNext();
		}
		return nodeValue;
	}

	public Object removeLast()
	{
		Object nodeValue;
		if(isEmpty())
		{
			throw new IllegalArgumentException("NAH!");
		}
		else if(head.getNext() == null)
		{
			nodeValue = head.getValue();
			head = null;
		}
		else
		{
			DSAListNode prevNd = null;
			DSAListNode currNd = head;
			while(currNd.getNext() != null)
			{
				prevNd = currNd;
				currNd = currNd.getNext();
			}
			prevNd.setNext(null);
			nodeValue = currNd.getValue();
		}
		return nodeValue;
	}
}

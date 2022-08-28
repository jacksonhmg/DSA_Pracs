import java.util.*;

public class DSALinkedList implements Iterable
{
	

	public Iterator iterator()
	{
		return new DSALinkedListIterator(this);
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
	private DSAListNode tail;

	public DSALinkedList()
	{
		head = null;
		tail = null;
	}

	public void insertFirst(Object newValue)
	{
		DSAListNode newNd = new DSAListNode(newValue);
		if(isEmpty())
		{
			head = newNd;
			tail = newNd;
		}
		else
		{
			newNd.setNext(head);
			head.setPrev(newNd);
			head = newNd;
		}
	}

	public void insertLast(Object newValue)
	{
		DSAListNode newNd = new DSAListNode(newValue);
		if(isEmpty())
		{
			head = newNd;
			tail = newNd;
		}
		else
		{
			tail.setNext(newNd);
			newNd.setPrev(tail);
			tail = newNd;
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
			throw new IllegalArgumentException("List is empty so cannot peek first");
		}
		else
		{
			return head.getValue();
		}
	}

	public Object peekLast()
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("List is empty so cannot peek last");
		}
		else
		{
			return tail.getValue();
		}
	}

	public Object removeFirst()
	{
		Object nodeValue;
		if(isEmpty())
		{
			throw new IllegalArgumentException("List is empty so cannot remove first");
		}
		else if(head.getNext() == null)
		{
			nodeValue = head.getValue();
			head = null;
			tail = null;
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
			throw new IllegalArgumentException("List is empty so cannot remove last");
		}
		else if(head.getNext() == null)
		{
			nodeValue = head.getValue();
			head = null;
			tail = null;
		}
		else
		{
			nodeValue = tail.getValue();
			tail = tail.getPrev();
		}
		return nodeValue;
	}
}

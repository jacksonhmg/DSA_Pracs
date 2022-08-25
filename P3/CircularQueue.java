// Circular Queue implementation in Java

public class CircularQueue extends DSAQueue{
    int SIZE = 5; // Size of Circular Queue
    int front, rear;
    Object items[] = new Object[SIZE];
  
    public CircularQueue() {
      front = -1;
      rear = -1;
    }
  
    // Check if the queue is full
    public boolean isFull() {
      if (front == 0 && rear == SIZE - 1) {
        return true;
      }
      if (front == rear + 1) {
        return true;
      }
      return false;
    }
  
    // Check if the queue is empty
    public boolean isEmpty() {
      if (front == -1)
        return true;
      else
        return false;
    }
  
    // Adding an element
    public void enqueue(Object element) {
      if (isFull()) {
        System.out.println("Queue is full");
      } else {
        if (front == -1)
          front = 0;
        rear = (rear + 1) % SIZE;
        items[rear] = element;
        System.out.println("Inserted " + element);
      }
    }
  
    // Removing an element
    public Object dequeue() {
      Object element;
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return (-1);
      } else {
        element = items[front];
        if (front == rear) {
          front = -1;
          rear = -1;
        } /* Q has only one element, so we reset the queue after deleting it. */
        else {
          front = (front + 1) % SIZE;
        }
        return (element);
      }
    }
  
    public void display() {
      /* Function to display status of Circular Queue */
      int i;
      if (isEmpty()) {
        System.out.println("Empty Queue");
      } else {
        System.out.println("Front -> " + front);
        System.out.println("Items -> ");
        for (i = front; i != rear; i = (i + 1) % SIZE)
          System.out.print(items[i] + " ");
        System.out.println(items[i]);
        System.out.println("Rear -> " + rear);
      }
    }
  
  
  }

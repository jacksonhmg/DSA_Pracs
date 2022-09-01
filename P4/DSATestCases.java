import java.io.*;

public class DSATestCases {
    
    public static void main(String args[])
    {
        DSAStack stack = null;
        String sTestString;
        int iNumPassed = 0;
        int iNumTests = 0;

        System.out.println("Testing All Stack Features");

        // TEST 1 : Constructor
        try
        {
            iNumTests ++;
            stack = new DSAStack();
            System.out.print("Testing if new stack is empty: ");
            if(stack.isEmpty() == false){
                throw new IllegalArgumentException("Count must not be zero");
            }
            iNumPassed++;
            System.out.println("Passed!");
        } catch(Exception e){
            System.out.println("Failed!");
        }

        //TEST 2 : Push
        try
        {
            iNumTests++;
            System.out.print("Testing push: ");
            stack.push("abc");
            stack.push(123);
            stack.push("hey!");
            stack.push(123.00);
            stack.push("hello");
            iNumPassed++;
            System.out.println("Passed!");
        } catch (Exception e){
            System.out.println("Failed!");
        }


        //TEST 5 : Top
        try
        {
            iNumTests++;
            System.out.print("Testing top method: ");
            if(!(stack.top().equals("hello"))){
                throw new IllegalArgumentException("Top return was incorrect");
            }
            iNumPassed++;
            System.out.println("Passed!");
        } catch (Exception e){
            System.out.println("Failed!");
        }

        //TEST 6 : Pop

        try
        {
            iNumTests++;
            System.out.print("Testing pop: ");
            sTestString = (String) stack.pop();
            if(!(sTestString.equals("hello"))){
                throw new IllegalArgumentException("Pop return was not correct");
            }
            iNumPassed++;
            System.out.println("Passed!");
        } catch (Exception e){
            System.out.println("Failed");
        }

        System.out.println("Number PASSED: " + iNumPassed + "/" + iNumTests);





        //DSA QUEUE -------------------------------------------------------------------

        DSAQueue queue = null;
        iNumPassed = 0;
        iNumTests = 0;

        System.out.println("---------------------------------");
        System.out.println("Testing All Queue Features");

        // TEST 1 : Constructor
        try
        {
            iNumTests ++;
            queue = new DSAQueue();
            System.out.print("Testing if new queue is empty: ");
            if(queue.isEmpty() == false){
                throw new IllegalArgumentException("Count must not be zero");
            }
            iNumPassed++;
            System.out.println("Passed!");
        } catch(Exception e){
            System.out.println("Failed!");
        }

        //TEST 2 : Enqueue
        try
        {
            iNumTests++;
            System.out.print("Testing enqueue: ");
            queue.enqueue("abc");
            queue.enqueue(123);
            queue.enqueue("hey!");
            queue.enqueue(123.00);
            queue.enqueue("hello");
            iNumPassed++;
            System.out.println("Passed!");
        } catch (Exception e){
            System.out.println("Failed!");
        }


        //TEST 5 : Peek
        try
        {
            iNumTests++;
            System.out.print("Testing peek method: ");
            if(!(queue.peek().equals("abc"))){
                throw new IllegalArgumentException("Peek return was incorrect");
            }
            iNumPassed++;
            System.out.println("Passed!");
        } catch (Exception e){
            System.out.println("Failed!");
        }

        //TEST 6 : dequeue

        try
        {
            iNumTests++;
            System.out.print("Testing dequeue: ");
            sTestString = (String) queue.dequeue();
            if(!(sTestString.equals("abc"))){
                throw new IllegalArgumentException("Pop return was not correct");
            }
            iNumPassed++;
            System.out.println("Passed!");
        } catch (Exception e){
            System.out.println("Failed");
        }

        System.out.println("Number PASSED: " + iNumPassed + "/" + iNumTests);
    }
}
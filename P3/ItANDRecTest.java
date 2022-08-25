import java.io.*;
import java.util.*;
public class ItANDRecTest {
    public static void main(String args[]){
        DSAStack stack = new DSAStack();
        //Factorial fact = new Factorial();
        Scanner sc = new Scanner(System.in);
        try{
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Adding iterative fib value of " + x + " to stack");
            stack.push(Factorial.fibIterative(x));
            System.out.println("Adding recursive fib value of " + y + " to stack");
            stack.push(Factorial.fibRecursive(y));
        } catch (Exception e){
            System.out.println("Error occurred when adding to stack");
        }
        stack.display();
        System.out.println();
        try{
            Object pop1 = stack.pop();
            System.out.println("First popped value is " + pop1);
            Object pop2 = stack.pop();
            System.out.println("Second popped value is " + pop2);
            Object pop3 = stack.pop();
        } catch (Exception e){
            System.out.println("Not enough items left to pop!");
        }
    }
}

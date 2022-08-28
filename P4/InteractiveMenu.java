import java.util.Iterator;
import java.util.Scanner;

public class InteractiveMenu
{
	public static void main(String[] args)
    {
        DSALinkedList list = new DSALinkedList();
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.println("A Linked List has been created, what would you like to do?");
        while(loop)
        {
            System.out.println("> 1 = InsertFirst onto the list");
            System.out.println("> 2 = InsertLast onto the list");
            System.out.println("> 3 = RemoveFirst on the list");
            System.out.println("> 4 = RemoveLast on the list");
            System.out.println("> 5 = Display the list");
            System.out.println("> 6 = Write a serialised file");
            System.out.println("> 7 = Read a serialised file");
            System.out.println();
            System.out.println("Enter selection: ");
            int input = sc.nextInt();
            switch(input)
            {
                case 1:
                    System.out.println("You have selected InsertFirst: Enter your input");
                    sc.nextLine();
                    inputString = sc.nextLine(); 
                    list.insertFirst(inputString);
                break;
                case 2:
                    System.out.println("You have selected InsertLast: Enter your input");
                    sc.nextLine();
                    inputString = sc.nextLine(); 
                    list.insertLast(inputString);
                break;
                case 3:
                    System.out.println("You have chosen RemoveFirst and have removed: " + list.removeFirst());
                break;
                case 4:
                System.out.println("You have chosen RemoveLast and have removed: " + list.removeLast());
                break;
                case 5:
                System.out.println("List is as follows: ");
                    Iterator iList = list.iterator();
                    while(iList.hasNext() != false)
                    {
                        System.out.println(iList.next());
                    }
                break;
                case 6:
                    System.out.println("Writing to DSALinkedList.txt");
                    list.save(list, "DSALinkedList.xml");
                break;
                case 7:
                    System.out.println("Loading from DSALinkedList.xml");
                    list = list.load("DSALinkedList.txt");
                break;
            }
        }
        
    }



}

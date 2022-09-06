import java.util.Iterator;
import java.util.Scanner;

public class InteractiveMenu {

	public static void main(String[] args)
    {
        BinarySearchTree BST = new BinarySearchTree("4",4);
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.println("A Linked List has been created, what would you like to do?");
        while(loop)
        {
            System.out.println("> 1 = Insert onto tree");
            System.out.println("> 2 = Delete from the tree");
            System.out.println("> 3 = Display tree in order");
            System.out.println("> 4 = Display tree pre order");
            System.out.println("> 5 = Display tree post order");
            System.out.println("> 6 = Find min");
            System.out.println("> 7 = Display the list");
            System.out.println("> 8 = Write a serialised file");
            System.out.println("> 9 = Read a serialised file");
            System.out.println();
            System.out.println("Enter selection: ");
            int input = sc.nextInt();
            System.out.println("=======================================");
            switch(input)
            {
                case 1:
                    System.out.println("You have selected to insert: Enter your input");
                    sc.nextLine();
                    inputString = sc.nextLine(); 
                    BST.insert(inputString, inputString);
                break;
                case 2:
                    System.out.println("You have selected to delete: Enter your input");
                    sc.nextLine();
                    inputString = sc.nextLine(); 
                    BST.delete(inputString);
                break;
                case 3:
                    BST.inOrderTraverse();
                break;
                case 4:
                    BST.preOrderTraverse();
                break;
                case 5:
                    BST.postOrderTraverse();
                break;
                case 6:

                break;
                case 7:
                
                break;
                case 8:
                    System.out.println("Writing to BST.txt");
                    BST.save(BST, "BST.txt");
                break;
                case 9:
                    System.out.println("Loading from BST.txt");
                    BST = BST.load("BST.txt");
                break;
            }
        }
        
    }

}

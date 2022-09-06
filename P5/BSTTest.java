import java.io.*;

public class BSTTest {
    public static void main(String[] args)
    {
        
        /*BinarySearchTree BST = new BinarySearchTree("4",4);
        BST.insert("2", 2);
        BST.insert("1", 1);
        BST.insert("3", 3);
        BST.insert("5", 5);
        BST.insert("6", 6);
        System.out.println(BST.balance());
        int x = BST.height();
        System.out.println("Height is (not including root): " + x);
        BST.inOrderTraverse();
        System.out.println();
        BST.preOrderTraverse();
        System.out.println();
        BST.postOrderTraverse();
        BST.delete("2");
        System.out.println();
        BST.inOrderTraverse();*/


        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        
        BinarySearchTree BST = new BinarySearchTree("4",4);

//---------------------------------------------------------------------------
        System.out.println("=======================================");

        // TEST 1 : Inserts
        try {
            iNumTests++;
            System.out.print("Testing inserts(): ");
            BST.insert("2", 2);
            BST.insert("1", 1);
            BST.insert("3", 3);
            BST.insert("5", 5);
            BST.insert("6", 6);
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

//---------------------------------------------------------------------------

        // TEST 2 : FIND
        try {
            iNumTests++;
            System.out.print("Testing find('2'): ");
            BST.find("2");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }


        // TEST 3 : HEIGHT
        try {
            iNumTests++;
            System.out.print("Testing height == 2: ");
            if(BST.height() != 2)
            {
                throw new IllegalArgumentException("Height isn't right");
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }


        // TEST 4 : BALANCE
        try {
            iNumTests++;
            System.out.print("Testing balance == 100%: ");
            if(BST.balance() != 100.0)
            {
                throw new IllegalArgumentException("Balance isn't right");
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 5 : MIN
        try {
            iNumTests++;
            System.out.print("Testing min == 1: ");
            if(BST.min() != 1)
            {
                throw new IllegalArgumentException("Min isn't right");
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 6 : MAX
        try {
            iNumTests++;
            System.out.print("Testing max == 6: ");
            if(BST.max() != 6)
            {
                throw new IllegalArgumentException("Max isn't right");
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }


        // TEST 7 : INORDER
        try {
            iNumTests++;
            System.out.println("Performing inOrderTraversal: ");
            BST.inOrderTraverse();
            iNumPassed++;
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 8 : PREORDER
        try {
            iNumTests++;
            System.out.println("Performing preOrderTraversal: ");
            BST.preOrderTraverse();
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 8 : POSTORDER
        try {
            iNumTests++;
            System.out.println("Performing postOrderTraversal: ");
            BST.postOrderTraverse();
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 10 : DELETE
        try {
            iNumTests++;
            System.out.print("Testing delete('2'): ");
            BST.delete("2");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 11 : INORDER
        try {
            iNumTests++;
            System.out.println("Performing inOrderTraversal: ");
            BST.inOrderTraverse();
            iNumPassed++;
        } catch(Exception e) { System.out.println("FAILED"); }

//---------------------------------------------------------------------------

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED: " + iNumPassed + "/" + iNumTests);
        System.out.print(" -> " + (int)(double)iNumPassed/iNumTests*100 + "%\n");
    }
//---------------------------------------------------------------------------
}

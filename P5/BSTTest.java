
public class BSTTest {
    public static void main(String[] args)
    {
        BinarySearchTree BST = new BinarySearchTree("1",1);
        BST.insert("2", 2);
        BST.insert("4", 4);
        BST.insert("6", 6);
        BST.insert("5", 5);
        BST.insert("3", 3);
        int x = BST.height();
        System.out.println(x);
        BST.inOrderTraverse();
    }
}

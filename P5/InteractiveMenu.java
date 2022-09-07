import java.util.*;
import java.io.*;

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
            System.out.println("> 6 = Write to csv");
            System.out.println("> 7 = Read from csv");
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
                    String sArray[] = readFile("BST.csv");
                    BinarySearchTree BSTTemp = new BinarySearchTree("4",4);
                    for(int i = 0; i < sArray.length;i++)
                    {
                        BSTTemp.insert(sArray[i], sArray[i]);
                    }
                    BST = BSTTemp;
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

    public static String[] readFile(String pFileName){
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;
        String[] stringArray = null;

        try{
            fileStream = new FileInputStream(pFileName); //all this is renewed again to start fresh to cycle through file from the top
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            line = bufRdr.readLine(); //where the actual data starts (the second line)
            if(line != null){
                stringArray = processLine(line);
            }
            fileStream.close();
            
            
        } catch(IOException errorDetails){
            if(fileStream != null){
                try{
                    fileStream.close();
                }catch(IOException ex2){

                }
            }
            System.out.println("An error! " + errorDetails.getMessage());
        }
        return stringArray;
    }


    public static String[] processLine(String csvRow){  //reading one row of a csv file at a time, separated by string.split method
        String[] splitLine;
        splitLine = csvRow.split(" "); //the -1 keeps empty cells in the line rather than remove them. the empty cells are then dealt with in the readFile method, as explained above
        return splitLine;
    }

    public static void writeOneRow(String pFileName, String pInputString){
        
        //MAKE WRITE ONE ROW WRITE IT SO THAT IT PRINTS EACH VALUE WITH A SPACE AFTER
        
        
        /*FileOutputStream fileStrm = null;
        PrintWriter pw;
        try {
            fileStrm = new FileOutputStream(pFileName);
            pw = new PrintWriter(fileStrm);
            pw.print(pInputString + " ");
            pw.close();
        } catch (IOException e) {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }*/
    }
}

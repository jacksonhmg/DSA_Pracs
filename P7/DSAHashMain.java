import java.io.*;
import java.util.*;

public class DSAHashMain {
    public static void main(String[] args)
    {
        DSAHashTable hTable = new DSAHashTable(100);
        readInHTable("RandomNames7000(1).csv", hTable);
        hTable.get(args[0]);
    }

    public static void readInHTable(String file, DSAHashTable hTable)
    {
        try{
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String[] sArray = processLine(data);
                hTable.resizeCheck();
                hTable.put(sArray[0], sArray[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String[] processLine(String csvRow)
    {  //reading one row of a file at a time, separated by string.split method
        String[] splitLine;
        splitLine = csvRow.split(","); 
        return splitLine;
    }
}

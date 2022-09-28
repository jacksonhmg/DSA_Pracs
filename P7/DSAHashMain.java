import java.io.*;
import java.util.*;

public class DSAHashMain {
    public static void main(String[] args)
    {
        DSAHashTable hTable = new DSAHashTable(100);
        readInHTable("RandomNames7000(1).csv", hTable);
        System.out.println(hTable.get(args[0]));
        outputToCSV("outputFile.csv", hTable);
        //System.out.println(hTable.hashArray.length);
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
                //System.out.println(sArray[0]);
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


    public static void outputToCSV(String pFileName, DSAHashTable hTable)
    {
        File f= new File(pFileName);           //file to be delete  
        f.delete();
        // String appendString = "";
        for(int i = 0; i < hTable.hashArray.length; i++)
        {
            if(hTable.hashArray[i].state == 1)
            {
                String appendString = hTable.hashArray[i].key + "," + (String)hTable.hashArray[i].value;
                writeOneRow(pFileName, appendString);
            }
        }
    }

    public static void writeOneRow(String pFileName, String pInputString){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(pFileName,true));
            pw.println(pInputString);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }
}

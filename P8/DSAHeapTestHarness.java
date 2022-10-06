import java.io.*;
import java.util.*;

public class DSAHeapTestHarness {
    public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        

//---------------------------------------------------------------------------
        System.out.println("=======================================");

        // TEST 1 : HeapEntry creation
        try {
            iNumTests++;
            System.out.print("Testing HeapEntry's creation: ");
            DSAHeapEntry heapEntry1 = new DSAHeapEntry(0,"test");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        DSAHeapEntry heapEntry1 = new DSAHeapEntry(0,"test");
        
        // TEST 2 : HeapEntry getPriority
        try {
            iNumTests++;
            System.out.print("Testing HeapEntry's getPriority: ");
            if((heapEntry1.getPriority()) != 0)
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 3 : HeapEntry getValue
        try {
            iNumTests++;
            System.out.print("Testing HeapEntry's getValue: ");
            if(!(heapEntry1.getValue()).equals("test"))
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 4 : HeapEntry setPriority
        try {
            iNumTests++;
            System.out.print("Testing HeapEntry's setPriority: ");
            heapEntry1.setPriority(1);
            if(heapEntry1.getPriority() != 1)
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }


        // TEST 5 : HeapEntry setValue
        try {
            iNumTests++;
            System.out.print("Testing HeapEntry's setValue: ");
            heapEntry1.setValue("test2");
            if(!heapEntry1.getValue().equals("test2"))
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 6 : heap creation
        try {
            iNumTests++;
            System.out.print("Testing heap creation: ");
            DSAHeap heap = new DSAHeap();
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        DSAHeap heap = new DSAHeap();

        // TEST 7 : heap add
        try {
            iNumTests++;
            System.out.print("Testing heap add: ");
            heap.add(0, "test");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED" + e); }


        // TEST 8 : heap remove
        try {
            iNumTests++;
            System.out.print("Testing heap remove: ");
            DSAHeapEntry returned = heap.remove();
            if(!returned.getValue().equals("test"))
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED" + e); }


        // TEST 9 : read in heap
        try {
            iNumTests++;
            System.out.print("Testing read in heap: ");
            readInHeap("RandomNames7000(2).csv",heap);
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED" + e); }

        // TEST 10 : heap sort
        try {
            iNumTests++;
            System.out.print("Testing heap sort: ");
            heap.heapSort();
            heap.print();
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED" + e); }

//---------------------------------------------------------------------------



        System.out.println("Number PASSED: " + iNumPassed + "/" + iNumTests);
    }

    public static void readInHeap(String file, DSAHeap heap)
    {
        try{
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String[] sArray = processLine(data);
                heap.add(Integer.parseInt(sArray[0]), sArray[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String[] processLine(String csvRow)
    {  //reading one row of a file at a time, separated by a space
        String[] splitLine;
        splitLine = csvRow.split(","); 
        return splitLine;
    }
}


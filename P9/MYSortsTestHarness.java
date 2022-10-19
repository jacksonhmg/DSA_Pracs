import java.util.Arrays;
import java.io.*;
import java.util.*;

/**
** Testharness to generate various different types of arrays of integers
** and then sort them using various sorts.
**
** Each sort is run REPEATS times, with the first result discarded, 
** and the last REPEATS-1 runs averaged to give the running time.
**
** Authour: Andrew Turpin (andrew@cs.curtin.edu.au)
** Date:    August 2004
** Modified: Patrick Peursum
** Date:     Sep 2009
*/
class MYSortsTestHarness 
{
    /** No of times to run sorts to get mean time */
    private static final int    REPEATS   = 4;

    /** number of items moved (% of n) in nearly sorted array */
    private static final double NEARLY_PERCENT = 0.10;

    /** No of times (*n) to randomly swap elements to get random array */
    private static final int    RANDOM_TIMES   = 100;

    private static void usage() 
    {
        System.out.println(" Usage: java TestHarness n xy [xy ...]");
        System.out.println("        where");
        System.out.println("        n is number of integers to sort");
        System.out.println("        x is one of");
        System.out.println("           b - bubblesort");
        System.out.println("           i - insertion sort");
        System.out.println("           s - selection sort");
        System.out.println("           q - quicksort");
        System.out.println("           m - mergesort");
        System.out.println("        y is one of");
        System.out.println("           a - 1..n ascending");
        System.out.println("           d - 1..n descending");
        System.out.println("           r - 1..n in random order");
        System.out.println("           n - 1..n nearly sorted (10% moved)");
    }

    /**
    ** Process command line arguments, generate array and call sort
    */
    public static void main(String[] args)
    {
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum = 0;
        String line;
        String pFileName = "RandomNames7000(2).csv";
        int n;
        char sortType, arrayType;
        if (args.length < 2)
            usage();
        else
            {
            //n = Integer.parseInt(args[0]);
            int[] A;
            for(int numSorts = 1 ; numSorts < args.length ; numSorts++)
                {
                sortType  = args[numSorts].charAt(0);
               
                double runningTotal = 0;
                for (int repeat = 0 ; repeat < REPEATS ; repeat++)
                {
                    // 
                    // Create array
                    // 
                    try{
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        lineNum = 0;
                        line = bufRdr.readLine();
                        while(line != null){
                            lineNum++; //for calculating length of CSV file used (number of lines)
                            line = bufRdr.readLine();
                        }
                        fileStream.close();
            
                        A = new int[lineNum];
            
                        fileStream = new FileInputStream(pFileName); //all this is renewed again to start fresh to cycle through file from the top
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine(); //i do an extra read line here before starting the actual loop to "THROW AWAY" the first line of the text file which was just the headers
                        for(int i=0; i < (lineNum); i++){  //keep within length that was found just prior
                            line = bufRdr.readLine(); //where the actual data starts (the second line)
                            if(line != null){
            
                            String [] stringArray = processLine(line);
            
                            for(int j = 0; j<stringArray.length; j++){
                                if(stringArray[j].isEmpty()){
                                    stringArray[j] = "0"; //dealing with empty cells. if any of the cells in a line were empty, they would just be assigned the value zero
                                }
                            }
                        A[i] = Integer.parseInt(stringArray[0]);
                           
                        }
            
                        }
                        fileStream.close();
                   
                    
              
                    //
                    // Do the sorting
                    // 
//                    long startTime = System.currentTimeMillis();
                    long startTime = System.nanoTime();
                    switch (sortType)
                    {
                        case 'b' : Sorts.bubbleSort(A); break;
                        case 's' : Sorts.selectionSort(A); break;
                        case 'q' : Sorts.quickSort(A); break;
                        case 'j' : Arrays.sort(A); break;    // Java's QuickSort
                        case 'm' : Sorts.mergeSort(A); break;
                        case 'i' : Sorts.insertionSort(A); break;
                        //case 'h' : Sorts.heapSort(A); break;
                        default :
                            throw new IllegalArgumentException("Unsupported sort type " + sortType);
                    }
//                    long endTime = System.currentTimeMillis();
                    long endTime = System.nanoTime();

                   

                    if (repeat == 0) {
                        // Check that it actually sorted correctly!
                        for(int i = 1 ; i < A.length; i++) {
                            if (A[i] < A[i-1])
                                throw new IllegalStateException("Array is not in sorted order! At element: " + i);                        
                        }
                    }
                    else {
                        // PP: Why is this code ignoring repeat #0?
                        // Is it attempting to downplay initial L2 caching?
                        runningTotal += (int)((double)(endTime - startTime) / 1000.0);	// Convert to microsecs
                    }
                    if((args[numSorts].charAt(0)) == ('b')){
                        writeOneRow("BubbleOutput.csv", A);
                    }
                    if((args[numSorts].charAt(0)) == ('i')){
                        writeOneRow("InsertionOutput.csv", A);
                    }
                    if((args[numSorts].charAt(0)) == ('s')){
                        writeOneRow("SelectionOutput.csv", A);
                    }
                }catch(IOException errorDetails){
                    if(fileStream != null){
                        try{
                            fileStream.close();
                        }catch(IOException ex2){
        
                        }
                    }
                    System.out.println("An error! " + errorDetails.getMessage());
                }// repeat sort
            }
              
                
                System.out.print(args[numSorts]+ " ");
                System.out.println(" " + (runningTotal/(REPEATS-1)));
            }// end for numSorts
         } // end else
        }
     //main()

    private static void swap(int[] A, int idx1, int idx2)
    {
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }
    public static String[] processLine(String csvRow){  //reading one row of a csv file at a time, separated by string.split method
    String[] splitLine;
    splitLine = csvRow.split(",", -1); //the -1 keeps empty cells in the line rather than remove them. the empty cells are then dealt with in the readFile method, as explained above
    return splitLine;
    }
    
    public static void writeOneRow(String pFilename, int[] pValArray){
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try {
            fileStrm = new FileOutputStream(pFilename);
            pw = new PrintWriter(fileStrm);
            for(int i = 0 ;i < pValArray.length; i ++){
                pw.println(pValArray[i] + " ");
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }

}

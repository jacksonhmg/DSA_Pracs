import java.io.*;
public class GraphTestHarness {
    public static void main(String[] args)
    {
        
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        
        DSAGraph DSAG = new DSAGraph();

//---------------------------------------------------------------------------
        System.out.println("=======================================");

        // TEST 1 : addVertex
        try {
            iNumTests++;
            System.out.print("Testing addVertex: ");
            DSAG.addVertex("4", "4");
            DSAG.addVertex("5", "5");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

//---------------------------------------------------------------------------

        // TEST 2 : addEdge
        try {
            iNumTests++;
            System.out.print("Testing addEdge: ");
            DSAG.addEdge("4", "5", false);;
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }


        // TEST 3 : hasVertex
        try {
            iNumTests++;
            System.out.print("Testing hasVertex: ");
            if(!(DSAG.hasVertex("4")))
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }


        // TEST 4 : hasEdge
        try {
            iNumTests++;
            System.out.print("Testing hasEdge: ");
            if(!(DSAG.hasEdge("4","5")))
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 5 : getVertexCount
        try {
            iNumTests++;
            System.out.print("Testing getVertexCount: ");
            if(DSAG.getVertexCount() != 2)
            {
                throw new IllegalArgumentException("VCount isn't right");
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 6 : getEdgeCount
        try {
            iNumTests++;
            System.out.print("Testing getEdgeCount: ");
            if(DSAG.getEdgeCount() != 1)
            {
                throw new IllegalArgumentException("ECount isn't right");
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }


        // TEST 7 : isAdjacent
        try {
            iNumTests++;
            System.out.print("Testing isAdjacent: ");
            if(!(DSAG.isAdjacent("4", "5")))
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

    

//---------------------------------------------------------------------------

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED: " + iNumPassed + "/" + iNumTests);
        System.out.print(" -> " + (int)(double)iNumPassed/iNumTests*100 + "%\n");
    }
//---------------------------------------------------------------------------
}


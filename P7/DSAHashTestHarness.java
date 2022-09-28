import java.io.*;

public class DSAHashTestHarness {
    public static void main(String[] args)
    {
        
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        
        DSAHashTable hTable = new DSAHashTable(100);

//---------------------------------------------------------------------------
        System.out.println("=======================================");

        // TEST 1 : put
        try {
            iNumTests++;
            hTable.put("name", "Jackson Mowatt Gok");
            hTable.put("dddu", "t2");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) 
        { 
            System.out.println("FAILED " + e); 
        }

//---------------------------------------------------------------------------

        // TEST 2 : get
        try {
            iNumTests++;
            System.out.print(hTable.get("name"));
            System.out.print(hTable.get("dddu"));
            iNumPassed++;
            System.out.println("\npassed");
        } catch(Exception e) { 
            System.out.println("FAILED " + e); 
        }


        // TEST 3 : hasKey
        try {
            iNumTests++;
            if(!(hTable.hasKey("name")))
            {
                throw new IllegalArgumentException();
            }
            if(!(hTable.hasKey("dddu")))
            {
                throw new IllegalArgumentException();
            }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) 
        { 
            System.out.println("FAILED " + e); 
        }


        // TEST 4 : remove
        try {
            iNumTests++;
            hTable.remove("name", "Jackson Mowatt Gok");
            hTable.remove("dddu", "Jackson Mowatt Gok");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) 
        { 
            System.out.println("FAILED " + e); 
        }

        // TEST 5 : get exception
        try {
            iNumTests++;
            hTable.get("name");
            hTable.get("dddu");
            System.out.println("FAILED");  
        } catch(Exception e) 
        {
            iNumPassed++;
            System.out.println("passed");
        }

        // TEST 6 : hasKey
        try {
            iNumTests++;
            if((hTable.hasKey("name")))
            {
                throw new IllegalArgumentException();
            }
            /*if((hTable.hasKey("dddu")))
            {
                throw new IllegalArgumentException();
            }*/
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED" + e); }


//---------------------------------------------------------------------------

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED: " + iNumPassed + "/" + iNumTests);
        System.out.print(" -> " + (int)(double)iNumPassed/iNumTests*100 + "%\n");
    }
//---------------------------------------------------------------------------
}


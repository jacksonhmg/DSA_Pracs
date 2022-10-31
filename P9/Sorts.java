import java.util.Random;

/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
	int pass = 0;
	boolean sorted;
	do{
		sorted = true;
		for(int ii = 0; ii <= (A.length - 1 - pass)-1; ii++)
		{
			if(A[ii] > A[ii+1])
			{
				int temp = A[ii];
				A[ii] = A[ii+1];
				A[ii+1] = temp;
				sorted = false;
			}
		}
	pass = pass +1;
	}
	while(!sorted);
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
	for(int nn = 0; nn < A.length; nn++)
	{
		int minIdx = nn;
		for(int jj = nn+1; jj < A.length; jj++)
		{
			if(A[jj] < A[minIdx])
			{
				minIdx = jj;
			}
		}
		int temp = A[minIdx];
		A[minIdx] = A[nn];
		A[nn] = temp;
	}
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
	for(int nn = 1; nn < A.length; nn++)
	{
		int ii = nn;
		int temp = A[ii];
		while((ii > 0) && (A[ii-1] > temp))
		{
			A[ii] = A[ii-1];
			ii -= 1;
		}
		A[ii] = temp;
	}
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
		mergeSortRecurse(A, 0, (A.length)-1);
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
		int midIdx;
		if(leftIdx < rightIdx)
		{
			midIdx = (leftIdx + rightIdx) / 2;
			mergeSortRecurse(A, leftIdx, midIdx);
			mergeSortRecurse(A, midIdx+1, rightIdx);
			merge(A, leftIdx, midIdx, rightIdx);
		}

    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
		int[] tempArr = new int[rightIdx - leftIdx + 1];
		int ii = leftIdx;
		int jj = midIdx + 1;
		int kk = 0;
		while(ii <= midIdx && jj <= rightIdx)
		{
			if(A[ii] <= A[jj])
			{
				tempArr[kk] = A[ii];
				ii ++;
			}
			else
			{
				tempArr[kk] = A[jj];
				jj ++;
			}
			kk ++;
		}
		for(int i = ii; i<midIdx+1; i++)
		{
			tempArr[kk] = A[i];
			kk ++;
		}
		for(int j = jj; j <rightIdx+1; j++)
		{
			tempArr[kk] = A[j];
			kk ++;
		}
		for(int k = leftIdx; k < rightIdx+1; k++)
		{
			A[k] = tempArr[k-leftIdx];
		}
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
		quickSortRecurse(A, 0, A.length-1);
    }//quickSort()

	public static void quickSortMed3(int[] A)
    {
		quickSortMed3Recurse(A, 0, A.length-1);
    }//quickSort()

	public static void quickSortRandom(int[] A)
    {
		quickSortRandomRecurse(A, 0, A.length-1);
    }//quickSort()
	
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
		int pivotIdx, newPivotIdx;
		if(rightIdx>leftIdx)
		{
			pivotIdx = (leftIdx + rightIdx) / 2;
			newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

			quickSortRecurse(A, leftIdx, newPivotIdx-1);
			quickSortRecurse(A, newPivotIdx+1, rightIdx);
		}
    }//quickSortRecurse()


	private static void quickSortMed3Recurse(int[] A, int leftIdx, int rightIdx)
    {
		int pivotIdx, newPivotIdx, midIdx;
		if(rightIdx>leftIdx)
		{
			midIdx = (leftIdx + rightIdx) / 2;
			int leftVal = A[leftIdx];
			int midVal = A[midIdx];
			int rightVal = A[rightIdx];


			if ((leftVal < midVal && midVal < rightVal) || (rightVal < midVal && midVal < leftVal))
			{
            	
			}
 
        // Checking for a
        	else if ((midVal < leftVal && leftVal < rightVal) || (rightVal < leftVal && leftVal < midVal))
        	{
				A[leftIdx] = midVal;
				A[midIdx] = leftVal;
			}
 
        	else
			{
        		A[rightIdx] = midVal;
				A[midIdx] = rightIdx;
			}

			pivotIdx = A[midIdx];
			newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

			quickSortRecurse(A, leftIdx, newPivotIdx-1);
			quickSortRecurse(A, newPivotIdx+1, rightIdx);
		}
    }//quickSortRecurse()

	private static void quickSortRandomRecurse(int[] A, int leftIdx, int rightIdx)
    {
		int pivotIdx, newPivotIdx;
		Random rand = new Random();
		if(rightIdx>leftIdx)
		{
			pivotIdx = rand.nextInt(A.length-1);
			newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

			quickSortRecurse(A, leftIdx, newPivotIdx-1);
			quickSortRecurse(A, newPivotIdx+1, rightIdx);
		}
    }//quickSortRecurse()



    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		int pivotVal = A[pivotIdx];
		A[pivotIdx] = A[rightIdx];
		A[rightIdx] = pivotVal;

		int currIdx = leftIdx;

		for(int i = leftIdx; i < rightIdx+1; i++)
		{
			if(A[i] < pivotVal)
			{
				int temp = A[i];
				A[i] = A[currIdx];
				A[currIdx] = temp;
				currIdx ++;
			}
		}
		int newPivIdx = currIdx;
		A[rightIdx] = A[newPivIdx];
		A[newPivIdx] = pivotVal;

		return newPivIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss

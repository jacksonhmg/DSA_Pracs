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
		mergeSortRecurse(A, A[0], A[A.length-1]);
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
		for(int i = ii; i<midIdx; i++)
		{
			tempArr[kk] = A[i];
			kk ++;
		}
		for(int j = jj; j <rightIdx; j++)
		{
			tempArr[kk] = A[j];
			kk ++;
		}
		for(int k = leftIdx; k < rightIdx; k++)
		{
			A[k] = tempArr[k-leftIdx];
		}
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss

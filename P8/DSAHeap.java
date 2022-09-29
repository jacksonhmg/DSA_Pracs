import java.util.Currency;

public class DSAHeap 
{
    private DSAHeapEntry[] heap;
    private int count;

    public void add(int priority, Object value)
    {
        DSAHeapEntry[] newHeap = new DSAHeapEntry[heap.length + 1];
        for(int i = 0; i < heap.length; i++)
        {
            newHeap[i] = heap[i];
        }
        newHeap[newHeap.length-1] = new DSAHeapEntry(priority, value);
        newHeap = trickleUp(newHeap, newHeap.length-1);
    }

    public DSAHeapEntry remove()
    {

    }

    public void display()
    {

    }

    private DSAHeapEntry[] trickleUp(DSAHeapEntry[] pHeap, int curIdx)
    {
        int parentIdx = (curIdx-1)/2;
        while(curIdx > 0 && pHeap[curIdx].getPriority() > pHeap[parentIdx].getPriority())
        {
            DSAHeapEntry temp = pHeap[parentIdx];
            pHeap[parentIdx] = pHeap[curIdx];
            pHeap[curIdx] = temp;
            curIdx = parentIdx;
            parentIdx = (curIdx-1)/2;
        }
        return pHeap;
    }

    private void trickleDown(DSAHeapEntry[] pHeap, int curIdx, int numItems)
    {
        int lChildIdx = curIdx * 2 + 1;
        int rChildIdx = lChildIdx + 1;
        boolean keepGoing = true;
        while(keepGoing && lChildIdx < numItems)
        {
            keepGoing = false;
            int largeIdx = lChildIdx;
            if(rChildIdx < numItems)
            {
                if(pHeap[lChildIdx].getPriority() < pHeap[rChildIdx].getPriority())
                {
                    largeIdx = rChildIdx;
                }
            }
            if(pHeap[largeIdx].getPriority() > pHeap[curIdx].getPriority())
            {
                swap(pHeap, largeIdx, curIdx);
                keepGoing = true;
            }
            curIdx = largeIdx;
            lChildIdx = curIdx * 2 + 1;
            rChildIdx = lChildIdx + 1;
        }
    }

    private void swap(DSAHeapEntry[] pHeap, int idx1, int idx2)
    {
        DSAHeapEntry temp = pHeap[idx1];
        pHeap[idx1] = pHeap[idx2];
        pHeap[idx2] = temp;
    }

}

import java.util.*;
import java.io.*;

public class DSAHeap 
{
    private DSAHeapEntry[] heap = new DSAHeapEntry[0];
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
        heap = newHeap;
    }

    public DSAHeapEntry remove()
    {
        DSAHeapEntry captRoot = heap[0];
        DSAHeapEntry[] newHeap = new DSAHeapEntry[heap.length-1];
        if(newHeap.length > 0)
        {
            newHeap[0] = heap[heap.length-1];
            for(int i = 1; i < heap.length - 1; i++)
            {
                newHeap[i] = heap[i];
            }
            newHeap = trickleDown(newHeap, 0, newHeap.length-1);
            heap = newHeap;
        }
        return captRoot;
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

    private DSAHeapEntry[] trickleDown(DSAHeapEntry[] pHeap, int curIdx, int numItems)
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
        return pHeap;
    }

    private void swap(DSAHeapEntry[] pHeap, int idx1, int idx2)
    {
        DSAHeapEntry temp = pHeap[idx1];
        pHeap[idx1] = pHeap[idx2];
        pHeap[idx2] = temp;
    }


    public DSAHeapEntry[] heapify(DSAHeapEntry[] heapArr, int numItems)
    {
        for(int ii = numItems/2; ii > -1; ii--)
        {
            trickleDown(heapArr, ii, numItems);
        }
        return heapArr;
    }

    public DSAHeapEntry[] heapSort()
    {
        DSAHeapEntry[] array = heap;
        heapify(array, array.length);
        for(int ii = array.length-1; ii > 0; ii--)
        {
            swap(array, 0, ii);
            trickleDown(array, 0, ii);
        }
        heap = array;
        return array;
    }

    public void print()
    {
        for(int i = 0; i < heap.length; i ++)
        {
            System.out.println(heap[i].getPriority() + " " + heap[i].getValue());
        }
    }
}

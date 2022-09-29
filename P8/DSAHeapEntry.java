public class DSAHeapEntry
{
    private int priority;
    private Object value;

    public DSAHeapEntry(int pPriority, Object pValue)
    {
        priority = pPriority;
        value = pValue;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int pPriority)
    {
        priority = pPriority;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object pValue)
    {
        value = pValue;
    }
}
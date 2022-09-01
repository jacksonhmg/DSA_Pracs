public class DSAGraphEdge {
    private DSAGraphVertex from;
    private DSAGraphVertex to;
    private Object label;
    private Object value;

    public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, Object inLabel, Object inValue)
    {
        from = fromVertex;
        to = toVertex;
        label = inLabel;
        value = inValue;
    }

    public Object getLabel()
    {
        return label;
    }

    public Object getValue()
    {
        return value;
    }

    public DSAGraphVertex getFrom()
    {
        return from;
    }

    public DSAGraphVertex getTo()
    {
        return to;
    }

    public boolean isDirected()
    {

    }

    public String toString()
    {
        
    }
}

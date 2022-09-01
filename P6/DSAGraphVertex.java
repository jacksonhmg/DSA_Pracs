public class DSAGraphVertex {
    private Object label;
    private Object value;
    private DSALinkedList links;
    private DSALinkedList visited;

    public DSAGraphVertex(Object inLabel, Object inValue)
    {
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

    public DSALinkedList getAdjacent()
    {
        return links;
    }

    public void addEdge(DSAGraphVertex vertex)
    {
        links.insertLast(vertex);
    }

    public void setVisited()
    {

    }

    public void clearVisited()
    {

    }

    public boolean getVisited()
    {

    }

    public String toString()
    {

    }
}

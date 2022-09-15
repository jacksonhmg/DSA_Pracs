import java.util.Iterator;

public class DSAGraphVertex {
    private Object label;
    private Object value;
    private DSALinkedList links = new DSALinkedList();
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

    public void setVisited(DSAGraphVertex vert)
    {
        visited.insertLast(vert);
    }

    public void clearVisited()
    {
        DSALinkedList newLL = new DSALinkedList();
        visited = newLL;
    }

    public boolean getVisited(DSAGraphVertex vert)
    {
        boolean check = false;
        Iterator ill = visited.iterator();
        while(ill.hasNext())
        {
            DSAGraphVertex tVert = (DSAGraphVertex)ill.next();
            if(tVert.getLabel() == vert.getLabel())
            {
                check = true;
            }
        }
        return check;
    }

    /*public String toString()
    {
        
    }*/
}

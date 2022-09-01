import java.util.*;
import java.io.*;

public class DSAGraph{
    private DSALinkedList vertices;
    private DSALinkedList edges;

    public void addVertex(Object label, Object value)
    {
        DSAGraphVertex vertex = new DSAGraphVertex(label, value);
        vertices.insertLast(vertex);
    }

    public void addEdge(Object label1, Object label2)
    {
        /*Iterator ill = vertices.iterator();
        DSAGraphVertex insFV = null;
        DSAGraphVertex insTV = null;
        Object inLabel = null;
        DSAGraphVertex inValue = null;
        while(ill.hasNext())
        {
            DSAGraphVertex testV = (DSAGraphVertex)ill.next();
            String sTestString = (String)testV.getLabel();
            if(sTestString.equals(label1))
            {
                insFV = testV;
                ill.getPoint().addEdge();
            }
            else if(sTestString.equals(label2))
            {
                insTV = testV;
            }
        }

        DSAGraphEdge edge = new DSAGraphEdge(insFV, insTV, inLabel, inValue);
        edges.insertLast(edge);*/

        DSAGraphEdge edge = new DSAGraphEdge(getVertex(label1), getVertex(label2), null, null);
        DSAGraphVertex vert1 = getVertex(label1);
        DSAGraphVertex vert2 = getVertex(label2);
        vert1.addEdge(vert2);
        vert2.addEdge(vert1);
        edges.insertLast(edge);
    }

    public boolean hasVertex(Object label)
    {
        Iterator ill = vertices.iterator();
        boolean check = false;
        while(ill.hasNext())
        {
            DSAGraphVertex testV = (DSAGraphVertex)ill.next();
            String sTestString = (String)testV.getLabel();
            if(sTestString.equals(label))
            {
                check = true;
            }
        }
        return check;
    }

    public int getVertexCount()
    {
        Iterator ill = vertices.iterator();
        int count = 0;
        while(ill.hasNext())
        {
            ill.next();
            count++;
        }
        return count;
    }

    public int getEdgeCount()
    {
        Iterator ill = edges.iterator();
        int count = 0;
        while(ill.hasNext())
        {
            ill.next();
            count++;
        }
        return count;
    }

    public DSAGraphVertex getVertex(Object label)
    {
        Iterator ill = vertices.iterator();
        DSAGraphVertex vertex = null;
        while(ill.hasNext())
        {
            DSAGraphVertex testV = (DSAGraphVertex)ill.next();
            String sTestString = (String)testV.getLabel();
            if(sTestString.equals(label))
            {
                vertex = testV;
            }
        }
        return vertex;
    }

    public DSALinkedList getAdjacent(Object label)
    {
        DSAGraphVertex vert = getVertex(label);
        DSALinkedList list = vert.getAdjacent();
    
        return list;
    }

    public boolean isAdjacent(Object label1, Object label2)
    {
        /*Iterator ill = vertices.iterator();
        DSALinkedList list = null;
        boolean check = false;
        while(ill.hasNext())
        {
            DSAGraphVertex testV = (DSAGraphVertex)ill.next();
            String sTestString = (String)testV.getLabel();
            if(sTestString.equals(label1))
            {
                list = testV.getAdjacent();
                Iterator ill2 = list.iterator();
                while(ill2.hasNext())
                {
                    DSAGraphVertex testV2 = (DSAGraphVertex)ill.next();
                    String sTestString2 = (String)testV.getLabel();
                    if(sTestString.equals(label2))
                    {
                        check = true;
                    }
                }
            }
        }
        return check;*/

        Iterator ill = edges.iterator();
        DSAGraphVertex vert1 = getVertex(label1);
        DSAGraphVertex vert2 = getVertex(label2);
        boolean checker = false;
        while(ill.hasNext())
        {
            DSAGraphEdge edge = (DSAGraphEdge)ill.next();

            if((edge.getFrom().equals(label1) && edge.getTo().equals(label2)) || (edge.getFrom().equals(label2) && edge.getTo().equals(label1)))
            {
                checker = true;
            }
        }
        
    }

    public void displayAsList()
    {
        Iterator ill = vertices.iterator();
        while(ill.hasNext())
        {
            Object label = ((DSAGraphVertex)(ill.next())).getLabel();
            
        }

    }

    public void displayAsMatrix()
    {

    }
}
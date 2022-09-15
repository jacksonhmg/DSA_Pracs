import java.util.*;
import java.io.*;

public class DSAGraph{
    private DSALinkedList vertices = new DSALinkedList();
    private DSALinkedList edges = new DSALinkedList();

    public void addVertex(Object label, Object value)
    {
        if(!(hasVertex(label)))
        {
            DSAGraphVertex vertex = new DSAGraphVertex(label, value);
            vertices.insertLast(vertex);
        }
    }

    public void addEdge(Object label1, Object label2)
    {
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
            Object sTest = testV.getLabel();
            if(sTest.equals(label))
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
            Object sTest = testV.getLabel();
            if(sTest.equals(label))
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
        return checker;
    }

    public void displayAsList()
    {
        Iterator ill = vertices.iterator();
        while(ill.hasNext())
        {
            DSAGraphVertex vert = ((DSAGraphVertex)(ill.next()));
            Object label = vert.getLabel();
            DSALinkedList list = vert.getAdjacent();
            System.out.print(label + ": ");
            Iterator ill2 = list.iterator();
            while(ill2.hasNext())
            {
                DSAGraphVertex vert2 = ((DSAGraphVertex)(ill2.next()));
                Object label2 = vert2.getLabel();
                System.out.print(label2 + " | ");
            }
            System.out.println();
        }

    }

    public void displayAsMatrix()
    {
        int count, tick;
        count = 0;
        tick = 0;
        Iterator tILL = vertices.iterator();
        while(tILL.hasNext())
        {
            count++;
            tILL.next();
        }
        
        Object[] headers = new Object[count];

        System.out.print(" | ");
        Iterator ill = vertices.iterator();
        while(ill.hasNext())
        {
            DSAGraphVertex vert = ((DSAGraphVertex)(ill.next()));
            Object label = vert.getLabel();
            headers[tick] = label;
            tick++;
            System.out.print(label + " | ");
        }
        System.out.println("REVISIT THIS");



        //BELOW CODE COULD BE USEFUL, JUST COMMENTING OUT TO NOT CLUTTER TEST HARNESS PRINT

        /*Iterator ill2 = vertices.iterator();
        while(ill2.hasNext())
        {
            DSAGraphVertex vert = ((DSAGraphVertex)(ill2.next()));
            Object label = vert.getLabel();
            DSALinkedList list = vert.getAdjacent();
            System.out.print(label + ": ");
            Iterator ill3 = list.iterator();
            while(ill3.hasNext())
            {
                DSAGraphVertex vert2 = ((DSAGraphVertex)(ill3.next()));
                Object label2 = vert2.getLabel();
                System.out.print(label2 + " | ");
            }
            System.out.println();
        }*/



    }


    public void breadthFirstSearch()
    {
        DSAQueue T = new DSAQueue();
        DSAQueue Q = new DSAQueue();
        Iterator clearILL = vertices.iterator();
        while(clearILL.hasNext())
        {
            DSAGraphVertex wipeV = (DSAGraphVertex)clearILL.next();
            wipeV.clearVisited();
        }
    }

}
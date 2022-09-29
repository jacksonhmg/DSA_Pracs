import java.io.*;
import java.util.*;

public class GraphTest {
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();
        DSAGraph graph2 = new DSAGraph();
        /*graph.addVertex('A', 'A');
        graph.addVertex('B', 'B');
        graph.addVertex('C', 'C');
        graph.addEdge('A', 'B',false);
        graph.addEdge('B', 'C',false);
        graph.addEdge('C', 'A',false);
        graph.displayAsList();
        System.out.println();
        graph.displayAsMatrix();
        System.out.println();*/

        //reading from file for graph
        
        try{
            File myObj = new File("prac6_2.al");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String[] sArray = processLine(data);
                graph2.addVertex(sArray[0], sArray[0]);
                graph2.addVertex(sArray[1], sArray[1]);
                graph2.addEdge(sArray[0], sArray[1],false);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        graph2.displayAsList();
        System.out.println();
        graph2.displayAsMatrix();
        graph2.breadthFirstSearch();
        System.out.println();
        System.out.println();
        graph2.depthFirstSearch();
    }

    public static String[] processLine(String csvRow)
    {  //reading one row of a csv file at a time, separated by string.split method
        String[] splitLine;
        splitLine = csvRow.split(" "); //the -1 keeps empty cells in the line rather than remove them. the empty cells are then dealt with in the readFile method, as explained above
        return splitLine;
    }

}



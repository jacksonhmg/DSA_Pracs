import java.io.*;
import java.util.*;

public class GraphTest {
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();
        DSAGraph graph2 = new DSAGraph();
        graph.addVertex('A', 'A');
        graph.addVertex('B', 'B');
        graph.addVertex('C', 'C');
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'A');
        graph.displayAsList();
        System.out.println();
        graph.displayAsMatrix();
        
        //reading from file for graph
        
        try{
            File myObj = new File("prac6_1.al");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String[] sArray = processLine(data);
                graph2.addVertex(sArray[0], sArray[0]);
                graph2.addVertex(sArray[1], sArray[1]);
                graph2.addEdge(sArray[0], sArray[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        graph2.displayAsList();
    }

    public static String[] processLine(String csvRow)
    {  //reading one row of a csv file at a time, separated by string.split method
        String[] splitLine;
        splitLine = csvRow.split(" "); //the -1 keeps empty cells in the line rather than remove them. the empty cells are then dealt with in the readFile method, as explained above
        return splitLine;
    }

}



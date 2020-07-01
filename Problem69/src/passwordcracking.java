import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
public class passwordcracking {
    ArrayList<String> list = new ArrayList<String>();
    Graph<String, Integer> graph1 = new DirectedSparseGraph<String, Integer>();

    public static void main(String[] args) {
        passwordcracking graph = new passwordcracking();
        graph.Read();
        String pass = graph.Solve();
        System.out.println("The passcode:" + pass);
        graph.PrintGraph();

    }
    public void PrintGraph() {

        Layout<String, Integer> layout =  new CircleLayout<String, Integer>(graph1);
        BasicVisualizationServer<String, Integer> vv = new BasicVisualizationServer<String, Integer>(layout);

        vv.setPreferredSize(new Dimension(600,600)); //Sets the viewing area size


        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());



        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);

    }


    //takes the number of verteces in the graph and creates a string from least to greatest incoming verteces
    //example: the first node would have no incoming vertices so it is the first in the string and so on
    public String Solve() {
        StringBuilder b =  new StringBuilder();
        int totalvertex = graph1.getVertexCount();
        String vertices = vertices();

        for(int i = 0; i < totalvertex; i++) {
            for(int j = 0; j < vertices.length(); j++) {
                String f = Character.toString(vertices.charAt(j));
                int x = graph1.getPredecessorCount(f);
                if(x == i) {
                    b.append(f);
                }
            }
        }
        return b.toString();
    }

    //creates string of the vertices
    public String vertices() {
        StringBuilder b =  new StringBuilder();
        for(int i = 0; i < graph1.getVertexCount(); i++) {
            String vertices = (String) graph1.getVertices().toArray()[i];
            b.append(vertices);
        }

        return b.toString();
    }

    //called on by read
    //adds each line into the graph
    public void MergeGraphs(String line) {

        //random weights generator
        Random generator = new Random();
        int y = -1;
        int z = -1;
        int x = -1;

        while(x <= 0 && y <= 0 && z<=0) {
            x = generator.nextInt();
            y = generator.nextInt();
            z = generator.nextInt();
        }

        //adding to graph
        //index 0 -> indexes 1,2 and index 1 -> index 2
        String indexzero = Character.toString(line.charAt(0));
        String indexone = Character.toString(line.charAt(1));
        String indextwo = Character.toString(line.charAt(2));

        graph1.addEdge(x, indexzero, indexone);
        graph1.addEdge(y, indexzero, indextwo);
        graph1.addEdge(z, indexone, indextwo);



    }

    //reads in the file
    public void Read() {
        String fileName = "p079_keylog.txt";
        String line = "";
        BufferedReader bufferedReader;

        try {
            bufferedReader= new BufferedReader(new FileReader(fileName));
            while(bufferedReader.ready())
            {
                line = bufferedReader.readLine();
                //adds line to a list
                list.add(line);
                //calls mergegraphs to add the line into the graph
                MergeGraphs(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found");
        }
        // catch any other exception
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}



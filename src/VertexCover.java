import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class VertexCover {
    private Graph graph;
    private int k;
    private int min;
    private ArrayList<Vertex> cover;
    ArrayList<ArrayList<Vertex>> possibleCovers = new ArrayList<ArrayList<Vertex>>();

    public VertexCover(Graph graph, int k) {
        this.graph = graph;
        this.k = k;
    }

    public static void main(String[] args) {

        Vertex[] graphVertices = { new Vertex(1), new Vertex(2),
                new Vertex(3), new Vertex(4), new Vertex(5)};

        Edge[] graphEdges = {
                new Edge(graphVertices[0], graphVertices[1]), new Edge(graphVertices[0], graphVertices[3]),
                new Edge(graphVertices[0], graphVertices[4]), new Edge(graphVertices[1], graphVertices[2]),
                new Edge(graphVertices[1], graphVertices[4]), new Edge(graphVertices[2], graphVertices[3]),
                new Edge(graphVertices[2], graphVertices[4]), new Edge(graphVertices[3], graphVertices[4])
        }; // the graph shown in the slides

        Graph graph = new Graph(graphVertices, graphEdges);
        System.out.println("# of Vertices: " + graph.numVertices());
        System.out.println(graph);
        VertexCover vc = new VertexCover(graph, 3);
        vc.greedyCover();

    }


    protected void removeEdges(Vertex vertex, ArrayList<Edge> edgeList) {
        ArrayList<Edge> removeEdge = new ArrayList<Edge>();

        for (int i = 0; i < edgeList.size(); i++) {
            if ((edgeList.get(i)).hasVertex(vertex))
                removeEdge.add(edgeList.get(i));
        }

        for (int i = 0; i < removeEdge.size(); i++)
            edgeList.remove(removeEdge.get(i));
    }

    // Allows VertexCover approaches to get the Vertex that has the most associated Edges
    protected Vertex getMaxDegree(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {

        Map<Vertex, Integer> map = new HashMap<Vertex, Integer>();// creates new instance to hold Vertices and their associated Vertex count
        int max = 0;// used to hold/determine which Vertex has the highest associated Vertex count
        Vertex maxVertex = new Vertex();// used to hold the Vertex with the highest associated Vertex count

        for (Vertex vertex : vertices) {// loops through the list of remaining Vertices in the search
            map.put(vertex,  0);// adds each Vertex to the map with an initial value of 0
            for (Edge edge : edges) {// loops through the list of remaining Edges in the search
                if (edge.hasVertex(vertex)) {// determines if an Edge contains a specific Vertex
                    map.put(vertex,map.get(vertex) + 1);// if the Edge contains the Vertex, the count associated with that Vertex is incremented
                }
            }
            if (map.get(vertex) > max) {// determines if the current Vertex has more associated Edges than the current max
                max = map.get(vertex);// if so, sets new max amount
                maxVertex = vertex;// if so, sets the maxVertex to the new Vertex that has the current max associated Edges
            }
        }

        return maxVertex;// returns the Vertex with the most associated Edges
    }// getMaxDegree(ArrayList<Vertex>, ArrayList<Edge>)

    protected void greedyCover() {
        ArrayList<Edge> edges = graph.getEdges();
        ArrayList<Vertex> vertices = graph.getVertices();
        cover = new ArrayList<Vertex>();// a new ArrayList<Vertex> to hold the Vertex cover

        while (!edges.isEmpty()) {// loops until a Vertex cover has been found
            Vertex vertex = getMaxDegree(vertices, edges);// gets the Vertex with the most associated Edges
            cover.add(vertex);// adds the Vertex found above to the Vertex cover list
            vertices.remove(vertex);// removes the Vertex found above from the list of available Vertices
            this.removeEdges(vertex, edges);// removes all the Edges that contain the Vertex found above as an endpoint
        }

        System.out.println("The vertices of the cover are: " + cover.toString());
    }

}



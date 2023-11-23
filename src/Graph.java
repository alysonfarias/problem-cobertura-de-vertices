
import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public Graph(Vertex[] newVertices, Edge[] newEdges) {

        edges = new ArrayList<Edge>();
        for (Edge edgeList : newEdges) {
            this.edges.add(edgeList);
        }

        vertices = new ArrayList<Vertex>();
        for (Vertex vertexList : newVertices){
            this.vertices.add(vertexList);
        }
    }

    protected Vertex getVertex(int i) {
        return vertices.get(i);
    }

    protected ArrayList<Edge> getEdges() {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (Edge edge : this.edges)
            edges.add(edge);
        return edges;
    }

    protected ArrayList<Vertex> getVertices() {
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        for (Vertex vertex : this.vertices)
            vertices.add(vertex);
        return vertices;
    }

    protected int numVertices() {
        return vertices.size();
    }

    public String toString() {
        return "Vertices: " + vertices.toString() + "\nEdges: " + edges.toString();
    }

}

public class Edge {

    private Vertex vertex1; // source vertex
    private Vertex vertex2; // destination vertex

    public Edge(Vertex vertex1, Vertex vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Vertex getVertex1() {
        return this.vertex1;
    }

    public Vertex getVertex2() {
        return this.vertex2;
    }

    public boolean hasVertex( Vertex vertex ) {
        return ( this.vertex1 == vertex || this.vertex2 == vertex );
    }

    public String toString() {
        return "(" + vertex1 + ", " + vertex2 + ")";
    }

}

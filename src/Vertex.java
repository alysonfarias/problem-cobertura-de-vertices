public class Vertex {

    private int vertexId;

    public Vertex(int vertexId) {
        this.vertexId = vertexId;
    }

    public Vertex() {
    }

    public int getVertexId() {
        return this.vertexId;
    }

    public String toString() {
        return Integer.toString(vertexId);// returns the printing prepared version of the Vertex
    }

}

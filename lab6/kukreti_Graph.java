import java.util.ArrayList;

public class kukreti_Graph implements ConnectedGraphFunctions{
	
	private final ArrayList<Integer> vertices;
	private final ArrayList<Edge> edges;
	private final boolean isDirected;
	
	kukreti_Graph()
	{
		this(false);
	}
	
	kukreti_Graph(boolean isDirected)
	{
		this.isDirected = isDirected;
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
	}
	
	public int getNumberOfVertices()
	{
		return vertices.size();
	}
	
	public int getNumberOfEdges()
	{
		return edges.size();
	}
	
	public boolean isDirected()
	{
		return isDirected;
	}
	
	public void addVertex(int v) throws GraphException
	{
		
	}
	
	public void addEdge(int from, int to) throws GraphException
	{
		
	}
	
	public String toString()
	{
		return "";
	}
	
	public boolean isConnected()
	{
		return false;
	}

}

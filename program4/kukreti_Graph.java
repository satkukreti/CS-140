import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayDeque;

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
		if (vertices.contains(v)) {
			throw new GraphException();
		}
		vertices.add(v);
	}
	
	public void addEdge(int from, int to) throws GraphException
	{
		if (!vertices.contains(from) || !vertices.contains(to)) {
			throw new GraphException();
		}
		Edge edge = new Edge(from, to);
		if (edges.contains(edge)) {
			throw new GraphException();
		}
		Edge reversedEdge = new Edge(to, from);
		if (!isDirected) {
			if(edges.contains(reversedEdge)) {
				throw new GraphException();
			}
		}
		edges.add(edge);
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		
		s.append("G = (V, E)\nV = {");
		
		for(Integer v: vertices) {
			s.append(v + ",");
		}
		s.deleteCharAt(s.length()-1);
		s.append("}\nE = {");
		for(Edge e: edges) {
			s.append("(" + e.fromVertex() + "," + e.toVertex() + "),");
		}
		s.deleteCharAt(s.length()-1);
		s.append("}");
		return s.toString();
	}
	
	public boolean isConnected()
	{
		if(isDirected) {
			boolean order = isConnected(edges);
			
			ArrayList<Edge> inverted = new ArrayList<>();
			for(int i = 0; i < edges.size(); i++) {
				Edge currentEdge = edges.get(i);
				int from = currentEdge.fromVertex();
				int to = currentEdge.toVertex();
				Edge reversedEdge = new Edge(to, from);
				inverted.add(reversedEdge);
			}
			
			boolean inverse = isConnected(inverted);
			
			return (order && inverse);
			
			
		} else {
			return isConnected(edges);
		}
		
	}
	
	private boolean isConnected(ArrayList<Edge> edges) {
		
		HashSet<Integer> connectedSubset = new HashSet<>();
		ArrayDeque<Integer> newlyAddedVertices = new ArrayDeque<>();
		connectedSubset.add(vertices.get(0));
		newlyAddedVertices.add(vertices.get(0));
		
		while(!(newlyAddedVertices.isEmpty())){
			int currentVertex = newlyAddedVertices.pollFirst(); //gets first element in newlyAddedVertex and removes it
			for(int i = 0; i < edges.size(); i++) {
				if (isDirected) {
					if(currentVertex == edges.get(i).fromVertex()) {
						if(connectedSubset.contains(edges.get(i).toVertex())) {
							continue;
						} else {
							connectedSubset.add(edges.get(i).toVertex());
							newlyAddedVertices.add(edges.get(i).toVertex());
						}
					}
				} else {
					if(currentVertex == edges.get(i).fromVertex()) {
						if(connectedSubset.contains(edges.get(i).toVertex())) {
							continue;
						}
						else {
							connectedSubset.add(edges.get(i).toVertex());
							newlyAddedVertices.add(edges.get(i).toVertex());
						}
					} else if(currentVertex == edges.get(i).toVertex()) {
						if(connectedSubset.contains(edges.get(i).fromVertex())) {
							continue;
						}
						else {
							connectedSubset.add(edges.get(i).fromVertex());
							newlyAddedVertices.add(edges.get(i).fromVertex());
						}
					}
				}
			}
		}
		
		if(connectedSubset.size() == vertices.size()) {
			return true;
		} else {
			return false;
		}
	}

}

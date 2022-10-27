
public class kukreti_VertexWithWeight{
	
	private final Integer vertex;
	private Double weight;
	
	public kukreti_VertexWithWeight(int v, double w)
	{
		vertex = v;
		weight = w;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double newW) {
		weight = newW;
	}
	
	public String toString() {
		return "(" + vertex + "," + weight + ")";
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o) //== for objects, checking if this and object o are held in the same memory
			return true;
		if (getClass() == o.getClass()) { //type VertexWithWeight
			if (vertex.intValue() == ((kukreti_VertexWithWeight) o).getVertex()){
				return true;
			}
		}
		return false;
	}
}

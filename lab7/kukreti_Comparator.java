
public class kukreti_Comparator implements java.util.Comparator<kukreti_VertexWithWeight>{
	
	public int compare (kukreti_VertexWithWeight o1, kukreti_VertexWithWeight o2) {
		
		if (o1.getWeight() > o2.getWeight())
			return 1;
		if (o1.getWeight() < o2.getWeight())
			return -1;
		if (o1.getWeight() == o2.getWeight() && o1.getVertex() > o2.getVertex())
			return 1;
		if (o1.getWeight() == o2.getWeight() && o1.getVertex() < o2.getVertex())
			return -1;
		return 0;
	}
}

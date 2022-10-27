//Iterator is like the old way to do the enhances for-loop
//the priorityqueue is stored in as a binary heap
//that is why the iterator and the toArray print out the same result for right after initialization
//as it is accessing the parent ,the left and right, then the left's left and right, then the right's left and right, etc.
//the poll() is just getting the first. lowest sorted element in the priority queue

import java.util.*;

public class kukreti_lab7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<kukreti_VertexWithWeight> p = new PriorityQueue<>(new kukreti_Comparator());
		kukreti_VertexWithWeight[] vww = new kukreti_VertexWithWeight[10];
		
		vww[0] = new kukreti_VertexWithWeight(0, 0.0);
		vww[1] = new kukreti_VertexWithWeight(1, 1.0);
		vww[2] = new kukreti_VertexWithWeight(2, 2.0);
		vww[3] = new kukreti_VertexWithWeight(3, 3.0);
		vww[4] = new kukreti_VertexWithWeight(4, 4.0);
		vww[5] = new kukreti_VertexWithWeight(5, 0.0);
		vww[6] = new kukreti_VertexWithWeight(6, 1.0);
		vww[7] = new kukreti_VertexWithWeight(7, 2.0);
		vww[8] = new kukreti_VertexWithWeight(8, 3.0);
		vww[9] = new kukreti_VertexWithWeight(9, 4.0);
		
		for (int i = 0; i < vww.length; i++) {
			p.add(vww[i]);
		}
		
		System.out.println("iterator after inital addition");
		Iterator iq = p.iterator();
		while (iq.hasNext()) {
			System.out.println(iq.next());
		}
		
		System.out.println("toArray after inital addition");
		kukreti_VertexWithWeight[] vArray = p.toArray(new kukreti_VertexWithWeight[0]);
		for (int i = 0; i < vArray.length; i++) {
			System.out.println(vArray[i]);
		}
		
		System.out.println("polling after inital addition");
		while(p.size() > 0) {
			System.out.println(p.poll());
		}
		
		//next part
		
		for (int i = 0; i < vww.length; i++) {
			p.add(vww[i]);
		}
		
		vww[0].setWeight(10.0);
		
		System.out.println("iterator after modification");
		Iterator iiq = p.iterator();
		while (iiq.hasNext()) {
			System.out.println(iiq.next());
		}
		
		System.out.println("toArray after modification");
		kukreti_VertexWithWeight[] vvArray = p.toArray(new kukreti_VertexWithWeight[0]);
		for (int i = 0; i < vvArray.length; i++) {
			System.out.println(vvArray[i]);
		}
		
		System.out.println("polling after modification");
		while(p.size() > 0) {
			System.out.println(p.poll());
		}
		
		//next part
		
		vww[0].setWeight(0.0);
		
		for (int i = 0; i < vww.length; i++) {
			p.add(vww[i]);
		}
		
		p.remove(vww[0]);
		
		vww[0].setWeight(10.0);
		
		p.add(vww[0]);
		
		System.out.println("polling after deletion, modification, and addition");
		while(p.size() > 0) {
			System.out.println(p.poll());
		}
		
	}

}

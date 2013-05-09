import java.util.ArrayList;
import java.util.List;


public class MyNode {
	BinaryTreeClass binfa = new BinaryTreeClass();
	List <MyEdge> outgoingEdges = new ArrayList<>();
	List <MyEdge> incomingEdges = new ArrayList<>();
	
	public MyNode() {
		super();
	}
	public void setOutGoingEdges (List <MyEdge> edges) {
		this.outgoingEdges = edges;
	}
	
	public List<MyEdge> getIncomingEdges() {
		return incomingEdges;
	}
	public void setIncomingEdges(List<MyEdge> incomingEdges) {
		this.incomingEdges = incomingEdges;
	}
	
	public List<MyEdge> getOutgoingEdges() {
		return outgoingEdges;
	}
	public int getNumberOfOutgoingEdges() {
		return outgoingEdges.size();
	}

	public int getNumberOfIncomingEdges() {
		return incomingEdges.size();
	}
	public BinaryTreeClass getBinfa() {
		return binfa;
	}
	public void setBinfa(BinaryTreeClass binfa) {
		this.binfa = binfa;
	}
	public String toString (MyNode node) {
		return node.toString();
	}
	
	public double getTheBinaryTreeValue () {
		return binfa.getTheBinfaValue();
	}
	
	
	


	

}

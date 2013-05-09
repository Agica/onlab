public class GraphProba {
	public static void main(String[] args) {
		Graph graph = new Graph();

		BinaryTreeClass binfa2 = new BinaryTreeClass();
		Operation op = new Operation('*');
		binfa2.setTheRootElement(op);
		Operation op2 = new Operation('+');
		op.setTheLeftChild(op2);
		Variable var1 = new Variable(1.0);
		op.setTheRightChild(var1);
		Variable var2 = new Variable(2.0);
		Variable var3 = new Variable(3.0);
		op2.setTheLeftChild(var2);
		op2.setTheRightChild(var3);
		

		MyNode first = graph.addVertex();
		first.setBinfa(binfa2);
		System.out.println(first.getTheBinaryTreeValue());
		
		BinaryTreeClass binfa3 = new BinaryTreeClass();
		
		Operation ope = new Operation('+');
		binfa3.setTheRootElement(ope);
		Operation ope2 = new Operation('+');
		ope.setTheLeftChild(ope2);
		Variable vare1 = new Variable(1.0);
		ope.setTheRightChild(vare1);
		Variable vare2 = new Variable(2.0);
		Variable vare3 = new Variable(3.0);
		ope2.setTheLeftChild(vare2);
		ope2.setTheRightChild(vare3);
		
		MyNode sec = graph.addVertex();
		sec.setBinfa(binfa3);
		System.out.println(binfa3.getTheBinfaValue());
		System.out.println(sec.getTheBinaryTreeValue());
		
		MyNode trd = graph.addVertex();
		trd.setBinfa(binfa3);
		
		for (MyNode node : graph.getVertices()) {
			for(MyNode node2: graph.getVertices()) {
				graph.addEdge(node, node2, true);
			}
		}
		System.out.println(graph.getNumberOfEdges());
		
		
		
	}

	

}

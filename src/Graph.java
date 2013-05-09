import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Graph /*implements ImplicitKeyedGraph*/{
	private List <MyNode> nList = new ArrayList<>();
	private List <MyEdge> eList = new ArrayList<>();

//	@Override
//	public Class<?> getVertexKeyClass() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Class<?> getEdgeKeyClass() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return nList.size();
	}

	
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return eList.size();
	}

	
	public Collection<MyNode> getVertices() {
		// TODO Auto-generated method stub
		return nList;
	}

	
	public Collection<MyEdge> getEdges() {
		// TODO Auto-generated method stub
		return eList;
	}

	
	public boolean containsVertex(MyNode vertexKey) {
		for(MyNode node : nList) {
			if(node == vertexKey ) {
				return true;
			}
		}
		return false;
	}

	
	public boolean containsEdge(MyEdge edgeKey) {
		for (MyEdge edge : eList ) {
			if(edge == edgeKey) {
				return true;
			}
		}
		return false;
	}

	

	public Object getSourceVertex(MyEdge edgeKey) {
		return edgeKey.getSourceVertex();
	}

	
	public Object getTargetVertex(MyEdge edgeKey) {
		return edgeKey.getTargetVertex();
	}

	public boolean isDirected(MyEdge edgeKey) {
		return edgeKey.isDirected();
	}

	
	public int getNumberOfConnectedEdges(MyNode vertexKey) {
		
		return vertexKey.getNumberOfOutgoingEdges()+vertexKey.getNumberOfIncomingEdges();
	}


	public int getDegree(MyNode vertexKey) {
	
		return -vertexKey.getNumberOfOutgoingEdges()+vertexKey.getNumberOfIncomingEdges();
	}


	public List<MyEdge> getConnectedEdges(MyNode vertexKey) {
		List<MyEdge> connectedEdges  = new ArrayList<>();
		for(MyEdge edge : vertexKey.getIncomingEdges()) {
			connectedEdges.add(edge);
		}
		for(MyEdge edge : vertexKey.getOutgoingEdges()) {
			connectedEdges.add(edge);
		}
		return connectedEdges;
	}

	
	public boolean isTraversable(MyNode from, MyNode to) {
		for (MyEdge fromEdge: from.getOutgoingEdges()) {
			for(MyEdge toEdge: to.getIncomingEdges()) {
				if (fromEdge == toEdge) {
					return true;
				}
			}
		}
		return false;
	}

	
	public boolean isConnected(MyNode vertexKey1, MyNode vertexKey2) {
		if(isTraversable(vertexKey1, vertexKey2) || isTraversable(vertexKey2, vertexKey1)) {
			return true;
		}
		return false;
	}


	public int getNumberOfTraversableSources(MyNode to) {
		return getTraversableSources(to).size();
	}


	public List<MyNode> getTraversableSources(MyNode to) {
		List <MyNode> sources = new ArrayList<>();
		for (MyEdge edge : to.getIncomingEdges()) {
			sources.add(edge.getSourceVertex());
		}
		return sources ;
	}

	
	public int getNumberOfTraversableTargets(MyNode from) {
		return getTraversableTargets(from).size();
	}

	
	public Collection<?> getTraversableTargets(MyNode from) {
		List <MyNode> targets = new ArrayList<>();
		for (MyEdge edge : from.getOutgoingEdges()) {
			targets.add(edge.getSourceVertex());
		}
		return targets ;
	}

	
	public int getNumberOfConnectedVertices(MyNode vertexKey) {
		
		return getNumberOfTraversableTargets(vertexKey)+getNumberOfTraversableSources(vertexKey);
	}

	
	public List<MyNode> getConnectedVertices(MyNode vertexKey) {
		List <MyNode> con = new ArrayList<>();
		for (MyEdge edge : vertexKey.getIncomingEdges()) {
			if (!con.contains(edge.getSourceVertex())) {
				con.add(edge.getTargetVertex());
			}
		}
		for (MyEdge edge : vertexKey.getOutgoingEdges()) {
			if (!con.contains(edge.getTargetVertex())) {
				con.add(edge.getTargetVertex());
			}
		}
		return con;
	}

	
	public int getNumberOfTraversableEdges(MyNode from, MyNode to) {
		
		return getTraversableEdges(from, to).size();
	}


	public List <MyEdge> getTraversableEdges(MyNode from, MyNode to) {
		List <MyEdge> trEdges = new ArrayList<>();
		for(MyEdge fromEdge : from.getOutgoingEdges()) {
			for(MyEdge toEdge : from.getIncomingEdges()) {
				if (fromEdge == toEdge) {
					trEdges.add(toEdge);
				}
			}
		}
		return trEdges;
	}

	
	public int getNumberOfConnectedEdges(MyNode vertexKey1, MyNode vertexKey2) {
		
		return getConnectedEdges(vertexKey1, vertexKey2).size();
	}

	
	public List <MyEdge> getConnectedEdges(MyNode vertexKey1, MyNode vertexKey2) {
		List <MyEdge> good = new ArrayList<>();
		for (MyEdge edge : getTraversableEdges(vertexKey1, vertexKey2)) {
			if (!good.contains(edge)) {
				good.add(edge);
			}
		}
		for (MyEdge edge : getTraversableEdges(vertexKey2, vertexKey1)) {
			if (!good.contains(edge)) {
				good.add(edge);
			}
		}
		return good;
	}

	
	public MyEdge getTraversableEdge(MyNode from, MyNode to) {
		
		return getTraversableEdges(from, to).get(0);
	}


	public MyEdge getConnectedEdge(MyNode vertexKey1, MyNode vertexKey2) {
	
		return getConnectedEdges(vertexKey1, vertexKey2).get(0);
	}

	
//	public MyNode getTraversableVertex(MyEdge edgeKey, MyNode vertexKey) {
//		
//		return getTr;
//	}
//
//	@Override
//	public Object getRemoteVertex(Object edgeKey, Object vertexKey) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public GraphObserverList getGraphObserverList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void addGraphObserver(GraphObserver observer) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void removeGraphObserver(GraphObserver observer) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void checkGraphStructure() {
//		// TODO Auto-generated method stub
//		
//	}

	
	public MyNode addVertex() {
		MyNode newNode = new MyNode();
		nList.add(newNode);
		return newNode;
	}

	
	public MyEdge addEdge(MyNode sourceKey, MyNode targetKey, boolean directed) {
		MyEdge newEdge = new MyEdge(sourceKey, targetKey, directed);
		eList.add(newEdge);
		return newEdge;
	}


	public void removeVertex(MyNode vertexKey) {
		nList.remove(vertexKey);
		
	}

	
	public void removeEdge(MyEdge edgeKey) {
		eList.remove(edgeKey);
		
	}
	


}

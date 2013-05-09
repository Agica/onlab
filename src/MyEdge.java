

public class MyEdge {
	
	private Graph graph;
	
	/** The source vertex. */
	private MyNode sourceVertex;
	
	/** The target vertex. */
	private MyNode targetVertex;
	
	/** The flag of directionality. */
	private boolean directed;
	
	/** The index. */
	private int index;
	
	/**
	 * Constructor for Edge.
	 * 
	 */
	public MyEdge() {
	}

	public MyEdge(MyNode sourceKey, MyNode targetKey, boolean directed2) {
		this.targetVertex = targetKey;
		this.sourceVertex = sourceKey;
		this.directed = directed2;
	}

	/**
	 * Getter for graph.
	 * 
	 * @return Value of graph.
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * Setter for graph.
	 * 
	 * @param graph
	 *            New value for graph.
	 */
	protected void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * Getter for sourceVertex.
	 * 
	 * @return Value of sourceVertex.
	 */
	public MyNode getSourceVertex() {
		return sourceVertex;
	}

	/**
	 * Setter for sourceVertex.
	 * 
	 * @param sourceVertex
	 *            New value for sourceVertex.
	 */
	protected void setSourceVertex(MyNode sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	/**
	 * Getter for targetVertex.
	 * 
	 * @return Value of targetVertex.
	 */
	public MyNode getTargetVertex() {
		return targetVertex;
	}

	/**
	 * Setter for targetVertex.
	 * 
	 * @param targetVertex
	 *            New value for targetVertex.
	 */
	protected void setTargetVertex(MyNode targetVertex) {
		this.targetVertex = targetVertex;
	}

	/**
	 * Checks if the edge is directed.
	 * 
	 * @return {@code true} when the edge is directed, {@code false}
	 *         otherwise.
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * Sets the directionality for the edge.
	 * 
	 * @param directed
	 *            {@code true} to declare the edge as directed
	 */
	protected void setDirected(boolean directed) {
		this.directed = directed;
	}

	/**
	 * Getter for index.
	 * 
	 * @return Value of index.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Setter for index.
	 * 
	 * @param index
	 *            New value for index.
	 */
	protected void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		return String.format("%s[#%d]", getClass().getSimpleName(), index);
	}

}

import java.util.List;


public class ElementClass implements Element {

	
	private List<Element> children;
	private Element leftChild;
	private Element rightChild;
	private boolean root;
	private boolean lr;

	private Element parent;

	@Override
	public boolean isRoot() {
		return root;
	}

	@Override
	public boolean hasChildren() {
		if (children.size() != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Element> getChildren() {
		return children;
	}

	@Override
	public Element getTheLeftChild() {
		return leftChild;
	}

	@Override
	public Element getTheRightChild() {
		return rightChild;
	}

	@Override
	public Element getParent() {
		return parent;
	}

	@Override
	public boolean hasParent() {
		if (parent != null)
			return true;
		else
			return false;
	}

	@Override
	public Element getSibling(Element element) {

		List<Element> children = getParent().getChildren();
		if (children.get(0) != element)
			return children.get(0);
		else
			return children.get(1);
	}

	
	@Override
	public void setParent(Element element) {
		this.parent = element;

	}

	@Override
	public void setTheLeftChild(Element element) {
		this.leftChild = element;
		element.setParent(this);
		element.setLR(true);
	}

	@Override
	public void setTheRightChild(Element element) {
		this.rightChild = element;
		element.setParent(this);
		element.setLR(false);

	}

	@Override
	public void setRoot(boolean root) {
		this.root = root;
		
	}
	@Override
	public void setLR (boolean value) {
		this.lr = value;
	}
	@Override
	public boolean getLR () {
		return lr;
	}

}

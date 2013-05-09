import java.util.List;


public interface Element {

	public boolean isRoot();
	
	public void setRoot (boolean root);
	
	public boolean hasChildren();
	
	public List<Element> getChildren();
	
	public Element getTheLeftChild();
	
	public Element getTheRightChild();
	
	public Element getParent();
	
	public boolean hasParent();
	
	public  Element getSibling(Element element);

	public void setParent (Element element);

	public void setTheLeftChild (Element element);
	
	public void setTheRightChild (Element element);
	
	public void setLR (boolean value);
	public boolean getLR ();
	
	

}

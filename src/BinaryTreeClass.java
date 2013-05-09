import java.util.List;


public class BinaryTreeClass implements BinaryTree {

	private int numberOfElements;
	private Element rootElement;
	// ez milyen lista legyen
	private List<Element> elements = null ;
	@Override
	public int getNumberOfElements() {
		return numberOfElements;
	}

	@SuppressWarnings("null")
	@Override
	public List<Element> getLeafs() {
		List <Element> leafs = null;
		for (Element element : elements)
			if (element.getChildren() == null) {
				leafs.add(element);
			}
		return leafs;
	}

	@Override
	public Element getTheRootElement() {
		return rootElement;
	}

	@Override
	public void setTheRootElement(Element element) {
		this.rootElement = element;
	}
	
	public List<Element> getTheElements () {
		return elements;
	} 
	
	public void setTheElement (Element element) {
		elements.add(element);
	}
	
	public void removeTheElement (Element element) {
		elements.remove(element);
	}
	
	public double getTheBinfaValue() {
		return kiolvas(this);
	}
	
	public void changeTheElement (BinaryTreeClass binfa, Element old,  double value) {
		Variable newElement = new Variable(value);
		if (old.getParent() != null) {
		if (old.getLR() == true ) {
			old.getParent().setTheLeftChild(newElement);
		}
		else if (old.getLR() == false ) {
			old.getParent().setTheRightChild(newElement);
		}
		newElement.setParent(old.getParent());
		}
		else binfa.setTheRootElement(newElement);
		
		
	}
	

	
	public static double kiszamol(Operation op, Variable a, Variable b) {
		char x = op.getTheOperation();
		double valueOfA = a.getTheVariable();
		double valueOfB = b.getTheVariable();

		if (x == '+') {
			return valueOfA + valueOfB;
		} else if (x == '*') {
			return valueOfA * valueOfB;
		} else if (x == '/') {
			return valueOfA / valueOfB;
		} else if (x == '-') {
			return valueOfA - valueOfB;
		} else
			throw new IllegalArgumentException("nincs ilyen muvelet");
	}

	public static double kiolvas(BinaryTreeClass binfa) {
		
		while (!(binfa.getTheRootElement() instanceof Variable)) {
			Element root = binfa.getTheRootElement();
			Element el = root;

			boolean bo = true;
			
			while (bo) {
				if (!(el.getTheLeftChild() instanceof Variable)) {
					el = el.getTheLeftChild();
					
				} else if (!(el.getTheRightChild() instanceof Variable)) {
					el = el.getTheRightChild();
					
				} else
					bo = false;
			}

			double ertek = kiszamol((Operation) el,
					(Variable) el.getTheLeftChild(),
					(Variable) el.getTheRightChild());
			binfa.changeTheElement(binfa, el, ertek);
			

			
		}

		return ((Variable) binfa.getTheRootElement()).getTheVariable();
	}
	

}

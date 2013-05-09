
public class Pr {
	
	static Operation op = new Operation('+');
	static Variable var1= new Variable(2.3);
	static Variable var2 = new Variable(3.4);
	
	public static void main (String [] args) {
		
			op.setRoot(true);
			op.setTheLeftChild(var1);
			op.setTheRightChild(var2);
			
			BinaryTreeClass binfa = new BinaryTreeClass();
			binfa.setTheRootElement(op);
			
			Operation root = (Operation) binfa.getTheRootElement();
			System.out.println(root.toString());
			
			Variable a = (Variable) root.getTheLeftChild();
			Variable b = (Variable) root.getTheRightChild();
			
			double eredmeny = kiszamol (root, a, b);
			System.out.println(eredmeny);
			
			System.out.println("ez" + kiolvas(binfa));
			
			BinaryTreeClass binfa2 = new BinaryTreeClass();
			Operation op = new Operation('*');
			binfa2.setTheRootElement(op);
			Operation op2 = new Operation ('+');
			op.setTheLeftChild(op2);
			Variable var1 = new Variable(1.0);
			op.setTheRightChild(var1);
			Variable var2 = new Variable(2.0);
			Variable var3 = new Variable(3.0);
			op2.setTheLeftChild(var2);
			op2.setTheRightChild(var3);
		System.out.println(kiolvas(binfa2));
			
		}
	
	public static double kiszamol (Operation op, Variable a, Variable b) {
		char x = op.getTheOperation();
		double valueOfA = a.getTheVariable();
		double valueOfB = b.getTheVariable();
		
		if (x == '+') {
			return valueOfA + valueOfB;
		}
		else if (x == '*') {
			return valueOfA * valueOfB;
		}
		else if (x == '/') {
			return valueOfA / valueOfB;
		}
		else if (x == '-') {
			return valueOfA - valueOfB;
		}
		else throw new IllegalArgumentException ("nincs ilyen muvelet");
	}
	
	public static double kiolvas (BinaryTreeClass binfa) {
		
		while(!(binfa.getTheRootElement() instanceof Variable)) {
			Element root = binfa.getTheRootElement();
			Element el = root;

			boolean bo = true;
			boolean change = false;
			while (bo) {
				if (!(el.getTheLeftChild() instanceof Variable)) {
					el = el.getTheLeftChild();	
					change = true;
				}
				else if(!(el.getTheRightChild() instanceof Variable)) {
					el = el.getTheRightChild();
					change = true;
				}
				else bo = false;
			}
		
		double ertek = kiszamol ((Operation)el, (Variable) el.getTheLeftChild(), (Variable) el.getTheRightChild());
		Variable newEl = new Variable(ertek);
		if (change) el = newEl;
		binfa.setTheRootElement(newEl);
		}

		return ((Variable) binfa.getTheRootElement()).getTheVariable();
}
	
	
}

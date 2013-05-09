import java.util.List;

public class Operation extends ElementClass {
	// ez így jó?
	private Character op;
	
	public Operation (char op) {
		this.op = op;
	}
	
	public char getTheOperation() {
		return op;
	}

	public void setTheOperation(char op) {
		this.op = op;
	}
	
	public String toString () {
		return op.toString();
	}
}


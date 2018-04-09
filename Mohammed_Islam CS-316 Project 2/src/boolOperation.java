
public class boolOperation extends FunOp {
	
	String val;
	
	public boolOperation(String mal){
		val = mal;
	}

	@Override
	public void printParseTree(String indent) {
		IO.displayln(indent+indent.length()+" "+val);
		
	}

}


public class ArithOperation extends FunOp {
	
	char balsal;
	
	public ArithOperation(char s){
		balsal = s;
	}

	@Override
	public void printParseTree(String indent) {
		IO.displayln(indent+indent.length()+" "+balsal);
		
	}

}

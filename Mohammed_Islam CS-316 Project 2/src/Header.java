
public class Header {

	Type t;
	FunName fn;
	ParameterList pl;
	
	public Header(Type ty, FunName f, ParameterList p){
		t = ty;
		fn = f;
		pl = p;
	}
	
	public void printParseTree(String indent){
		String indent1 = indent+" ";
		IO.displayln(indent+indent.length()+" <Header>");
		t.printParseTree(indent1);
		fn.printParseTree(indent1);
		pl.printParseTree(indent1);
	}
}

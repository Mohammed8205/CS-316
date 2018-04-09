
public class Parameter {

	Type ty;
	String id;
	
	public Parameter(Type t, String i){
		ty  = t;
		id = i;
	}
	
	public void printParseTree(String indent){
		//String indent1 = indent+" ";
		IO.display(indent+indent.length()+" <parameter> ");
		ty.setUp();
		IO.display(ty.token+" "+ id);
		IO.displayln("");
	}
}

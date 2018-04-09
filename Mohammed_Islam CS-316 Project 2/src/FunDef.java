
public class FunDef extends FunDefList {

	Header h;
	Exp e;
	
	public FunDef(Header he, Exp ex){
		h = he;
		e = ex;
	}
	
	@Override
	void printParseTree(String indent) {
		String indent1 = indent+" ";
		IO.displayln(indent+indent.length()+" <fun def>");
		h.printParseTree(indent1);
		IO.displayln(indent1+ indent1.length()+" <exp> ");
		e.printParseTree(indent1+" ");
	}

}

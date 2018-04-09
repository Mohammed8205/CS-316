
public class FunExp extends Exp {
	
	FunOp fn;
	ExpList exl;
	
	
	public FunExp(FunOp f, ExpList ex){
		fn = f;
		exl = ex;
	}
	
	public void printParseTree(String indent){
		IO.displayln(indent+indent.length()+" <Fun Exp> ");
		fn.printParseTree(indent+" ");
		exl.printParseTree(indent+" ");
	}

}

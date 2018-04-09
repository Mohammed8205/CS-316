
public class ExpListRepeat extends ExpList{
	
	ExpList el;
	
	public ExpListRepeat(Exp e, ExpList li){
		exp = e;
		el = li;
	}
	
	public void printParseTree(String indent){
		exp.printParseTree(indent);
		el.printParseTree(indent);
	}
}

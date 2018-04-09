
public class ParamListWithBracket extends ParameterList {

	public ParamListWithBracket(Parameters p){
		para = p;
	}
	
	public void printParseTree(String indent){
		IO.displayln(indent+indent.length()+" <Parameter List> ");
		para.printParseTree(indent+" ");
	}
}

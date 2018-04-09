
public class BooleanLiteral extends Exp {
	
	int sonkha;
	
	public BooleanLiteral(int notun){
		sonkha  = notun;
	}
	
	public void printParseTree(String indent){
		if(sonkha == 0){
			IO.displayln(indent+indent.length()+" <boolean literal> "+ "false");
		}
		else{
			IO.display(indent+indent.length()+" <boolean literal> "+ "true");
		}
	}

}

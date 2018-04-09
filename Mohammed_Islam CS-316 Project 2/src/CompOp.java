
public class CompOp extends FunOp {

	char boro_choto ;
	String soman;
	
	public CompOp(char c){
		boro_choto = c;
		soman = "";
	}
	
	public CompOp(String s){
		soman = s;
		boro_choto = ' ';
	}

	@Override
	public void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent+indent.length()+" <fun op> ");
		if(boro_choto != ' ')
		IO.displayln(indent+indent.length()+" "+boro_choto);
		else if(soman != "")
		IO.displayln(indent+indent.length()+" "+soman);
	}
	
	
}

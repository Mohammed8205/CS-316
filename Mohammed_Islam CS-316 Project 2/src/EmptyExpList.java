
public class EmptyExpList extends ExpList{
	
	public EmptyExpList(){
		
	}

	@Override
	public void printParseTree(String indent) {
		IO.displayln(indent+indent.length()+" <fun list> ");
		
	}

}

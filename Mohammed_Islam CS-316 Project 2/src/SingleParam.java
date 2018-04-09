
public class SingleParam extends Parameters{

	public SingleParam(Parameter p){
		par  = p;
	}

	@Override
	public void printParseTree(String indent) {
		par.printParseTree(indent);
		
	}
	
	
}

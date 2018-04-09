
public class ParamListRepeat extends Parameters {
	
	
	Parameters ps ;
	
	public ParamListRepeat(Parameter pr, Parameters p){
		ps = p;
		par = pr;		
	}

	@Override
	public void printParseTree(String indent) {
		par.printParseTree(indent);
		ps.printParseTree(indent);
	}

}

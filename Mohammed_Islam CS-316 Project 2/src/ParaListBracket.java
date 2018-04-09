
public class ParaListBracket extends ParameterList{

	Parameters pt;
	
	public ParaListBracket(Parameters p){
		pt = p;
	}
	
	@Override
	public void printParseTree(String indent) {
		// TODO Auto-generated method stub
		String indent1 = indent+" ";
		pt.printParseTree(indent1);
	}

}

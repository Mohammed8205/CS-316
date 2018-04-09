
public class ExpListFunExp extends Exp{
	
	FunExp fn;
	
	public ExpListFunExp(FunExp f){
		fn = f;
	}

	@Override
	public void printParseTree(String indent) {
		fn.printParseTree(indent);
	}

}

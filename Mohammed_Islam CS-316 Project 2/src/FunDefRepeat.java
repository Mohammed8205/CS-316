
public class FunDefRepeat extends FunDefList {
	
	FunDef fun;
	FunDefList fl;

	public FunDefRepeat(FunDef d, FunDefList f){
		fun = d;
		fl = f;
	}
	
	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		fun.printParseTree(indent);
		fl.printParseTree(indent);
	}

}

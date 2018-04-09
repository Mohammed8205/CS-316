class FunDef extends FunDefList
{
	Header header;
	Exp exp;
	
	FunDef(Header h, Exp e)
	{
		header = h;
		exp = e;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		IO.displayln(indent + indent.length() + " <fun def>");		
		header.printParseTree(indent1);
		exp.printParseTree(indent1);
	}

	@Override
	void buildTypeMaps() {
		// TODO Auto-generated method stub
		TypeChecker.indent = 0;
		header.buildTypeMaps();
		exp.buildTypeMaps();
		
	}

	@Override
	public TypeVal typeEval() {
		TypeVal ty = header.TypeEval();
		TypeVal typ = exp.TypeEval();
		if(ty == TypeVal.Error || typ == TypeVal.Error || ty == null || typ == null)return TypeVal.Error;
		else return TypeVal.Correct;
		
	}
}
class MultipleFunDef extends FunDefList
{
	FunDef funDef;
	FunDefList funDefList;
	
	MultipleFunDef(FunDef fdef, FunDefList fdeflist)
	{
		funDef = fdef;
		funDefList = fdeflist;
	}
	
	void printParseTree(String indent)
	{
		funDef.printParseTree(indent);
		IO.displayln("\n--------------------\n");
		funDefList.printParseTree(indent);
	}

	@Override
	void buildTypeMaps() {
		funDef.buildTypeMaps();
		TypeChecker.indent = 0;
		funDefList.buildTypeMaps();
	}

	@Override
	public TypeVal typeEval() {
		TypeVal tp = funDef.typeEval();
		TypeVal tp2 = funDefList.typeEval();
		if(tp == TypeVal.Error || tp == null || tp2 == TypeVal.Error || tp2 == null)return TypeVal.Error;
		else return TypeVal.Correct;
	}
}
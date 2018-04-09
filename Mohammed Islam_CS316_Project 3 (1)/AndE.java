class AndE extends FunExp
{
	ExpList expList;
	
	AndE(ExpList e)
	{
		expList = e;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " and");
		expList.printParseTree(indent2);
	}

	@Override
	public void buildTypeMaps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeVal TypeEval() {
		// TODO Auto-generated method stub
		return expList.TypeEval();
	}
}
class FunCall extends FunExp
{
	String funName;
	ExpList expList; // expList is null if <exp list> is empty.
	
	FunCall(String s, ExpList e)
	{
		funName = s;
		expList = e;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent + indent.length() + " <exp>");
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " " + funName);
		if ( expList != null )
			expList.printParseTree(indent2);
	}

	@Override
	public void buildTypeMaps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeVal TypeEval() {
		// TODO Auto-generated method stub
		System.out.println(funName);
		TypeChecker.temp = funName;
		if(expList != null)
		return expList.TypeEval();
		else return TypeVal.Correct;
	}
}
class ExpList
{
	Exp exp;
	ExpList expList; // expList is null at the end of the list.
	
	ExpList(Exp e, ExpList el)
	{
		exp = e;
		expList = el;
	}
		
	void printParseTree(String indent)
	{
		exp.printParseTree(indent);
		if ( expList != null )
			expList.printParseTree(indent);	
	}

	public TypeVal TypeEval() {
		TypeVal ty = exp.TypeEval();
		TypeVal ty2 = null;
		if(expList != null)
		ty2 = expList.TypeEval();
		if(ty == TypeVal.Error || ty2 == TypeVal.Error ||ty == null || ty2 == null )return TypeVal.Error;
		else return TypeVal.Correct;
	}
	
	
}
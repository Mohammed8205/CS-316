class If extends Exp
{
	Exp exp1;
	Exp exp2;
	Exp exp3;
	
	If(Exp e1, Exp e2, Exp e3)
	{
		exp1 = e1;
		exp2 = e2;
		exp3 = e3;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " if");		
		exp1.printParseTree(indent2);
		IO.displayln(indent1 + indent1.length() + " then");
		exp2.printParseTree(indent2);
		IO.displayln(indent1 + indent1.length() + " else");
		exp3.printParseTree(indent2);
	}

	@Override
	public void buildTypeMaps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeVal TypeEval() {
		// TODO Auto-generated method stub
		TypeVal ty = exp1.TypeEval();
		TypeVal ty2 = exp2.TypeEval();
		TypeVal ty3 = exp3.TypeEval();
		if(ty == TypeVal.Error || ty2 == TypeVal.Error || ty3 == TypeVal.Error )return TypeVal.Error;
		else return TypeVal.Correct;
	}
}
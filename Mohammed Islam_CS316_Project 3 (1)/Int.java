class Int extends Exp
{
	int intElem;
	
	Int(int i)
	{
		intElem = i;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + intElem);
	}

	@Override
	public void buildTypeMaps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeVal TypeEval() {
		// TODO Auto-generated method stub
		return TypeVal.Error;
	}
}
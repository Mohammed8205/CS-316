class Floatp extends Exp
{
	float floatElem;
	
	Floatp(float f)
	{
		floatElem = f;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + floatElem);
	}

	@Override
	public void buildTypeMaps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeVal TypeEval() {
		// TODO Auto-generated method stub
		System.out.println(floatElem);
		return TypeVal.Float;
	}
}
class ParameterList
{
	Parameters parameters;
	
	ParameterList(Parameters ps)
	{
		parameters = ps;
	}
	
	void printParseTree(String indent)
	{
		parameters.printParseTree(indent);
	}

	public void buildTypeMaps() {
		parameters.buildTypeMaps();
		
	}

	public TypeVal TypeEval() {
		TypeVal tp = parameters.typeEval();
		if(tp != TypeVal.Error || tp != null)return TypeVal.Correct;
		return tp;
	}
}
class Parameters
{
	Parameter parameter;
	Parameters parameters; // parameters is null at the end of the list.
	
	Parameters(Parameter p, Parameters ps)
	{
		parameter = p;
		parameters = ps;
	}
	
	void printParseTree(String indent)
	{
		parameter.printParseTree(indent);
		if ( parameters != null )
			parameters.printParseTree(indent);
	}
	
	public void buildTypeMaps(){
		parameter.buildTypeMaps();
		if(parameters!= null){
			parameters.buildTypeMaps();
		}
	}

	public TypeVal typeEval() {
		TypeVal tp = parameter.typeEval();
		if(parameters!= null){
			TypeVal t = parameters.typeEval();
			if(t == TypeVal.Error || tp == TypeVal.Error|| t == null || tp ==null)return TypeVal.Error;
		}
		return TypeVal.Correct;
	}
}
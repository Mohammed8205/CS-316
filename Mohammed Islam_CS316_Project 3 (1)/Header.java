class Header
{
	String type;
	String funName;
	ParameterList parameterList; // parameterList is null if <parameter list> is empty.
	
	Header(String t, String f, ParameterList p)
	{
		type = t;
		funName = f;
		parameterList = p;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <header>");
							  
		String indent1 = indent+" ";

		IO.displayln(indent1 + indent1.length() + " <type> " + type);
		IO.displayln(indent1 + indent1.length() + " <fun name> " + funName);
		if ( parameterList != null )
		{
			IO.displayln(indent1 + indent1.length() + " <parameter list>");
			parameterList.printParseTree(indent1+" ");
		}
	}

	public void buildTypeMaps() {
		TypeVal typo = TypeVal.toTypeVal(type);
		if(typo!= null){
			TypeChecker.funTypeMap.put(funName,typo);
			System.out.println(TypeChecker.funTypeMap.toString());
		}
		TypeChecker.currName = funName;
		if(parameterList != null){
		parameterList.buildTypeMaps();
		}
	}

	public TypeVal TypeEval() {
		TypeVal jasim = TypeVal.toTypeVal(type);
		if(jasim == null){
			IO.displayln("Invalid return type on function name "+ funName);
		}
		TypeVal ty = null;
		if(parameterList != null){
			ty = parameterList.TypeEval();
		}
		TypeChecker.funNames.add(funName);
		if(ty == TypeVal.Error)return TypeVal.Error;
		return TypeVal.Correct;
	}

}
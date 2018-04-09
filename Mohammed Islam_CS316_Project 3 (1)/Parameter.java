import java.util.HashMap;

class Parameter
{
	String type;
	String ident;
	
	Parameter(String t, String id)
	{
		type = t;
		ident = id;
		System.out.println();
	}
	
	void printParseTree(String indent)
	{
		IO.display(indent + indent.length() + " <parameter> " + type + " ");
		IO.displayln(ident);
	}

	public void buildTypeMaps() {
		TypeVal typo = TypeVal.toTypeVal(type);
		if(typo != null){
			HashMap<String,TypeVal> temp = new HashMap<String,TypeVal>();
			temp.put(ident, typo);
			if(TypeChecker.paramTypeMap.containsKey(TypeChecker.currName)){
				TypeChecker.paramTypeMap.get(TypeChecker.currName).put(ident,typo);
				
			}
			else{
			TypeChecker.paramTypeMap.put(TypeChecker.currName, temp);
			}
			HashMap<Integer,TypeVal> temp2 = new HashMap<Integer,TypeVal>();
			temp2.put(++TypeChecker.indent,typo);
			if(TypeChecker.paramNumTypeMap.containsKey(TypeChecker.currName)){
				TypeChecker.paramNumTypeMap.get(TypeChecker.currName).put(TypeChecker.indent,typo);
				
			}
			else
			TypeChecker.paramNumTypeMap.put(TypeChecker.currName, temp2);
		}
		
	}

	public TypeVal typeEval() {
		TypeVal ty = TypeVal.toTypeVal(type);
		if(ty == null){
			System.out.println("Wrong type of parameters in function "+ TypeChecker.currName);
		}
		if (ty == null) return TypeVal.Error;
		else return TypeVal.Correct;
	}
	
	
}
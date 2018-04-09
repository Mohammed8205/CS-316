import java.util.HashMap;

class Id extends Exp
{
	String id;
	
	Id(String s)
	{
		id = s;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + id);
	}

	@Override
	public void buildTypeMaps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeVal TypeEval() {
		TypeVal tp = null;
		HashMap<String,TypeVal>  h = TypeChecker.paramTypeMap.get(TypeChecker.temp);
		if(h!=null){
			if(!h.containsKey(id)){
				for(int i = 0; i<TypeChecker.funNames.size();i++){
					HashMap<String,TypeVal> h2 = TypeChecker.paramTypeMap.get(TypeChecker.funNames.get(i));
					if(h2!=null){
						if(h2.containsKey(id)){
							IO.displayln("Type Error : Uncompatible type in function " + TypeChecker.funNames.get(i));
						}
					}
				}
			}
		}
		
		return TypeVal.Correct;
	}
	
	
}
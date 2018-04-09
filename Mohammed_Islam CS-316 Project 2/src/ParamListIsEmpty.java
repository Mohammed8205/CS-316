
public class ParamListIsEmpty extends ParameterList {

	public ParamListIsEmpty(){};
	
	@Override
	public void printParseTree(String indent) {
		IO.displayln(indent+indent.length()+" <parameter list> "+ " ");
	}

}

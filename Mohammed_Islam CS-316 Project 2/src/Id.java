
public class Id extends Exp {

	String id;

	Id(String ident)
	{
		id = ident;
	}

	public void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <Exp> ");
		indent+=" ";
		IO.displayln(indent+indent.length()+" "+id);
	}
}

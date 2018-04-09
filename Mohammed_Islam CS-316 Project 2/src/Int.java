
public class Int extends Exp {

	int val;

	Int(int i)
	{
		val = i;
	}

	public void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <Exp> " + val);
	}
}

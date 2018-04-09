
public class Float extends Exp{

	float dosomik;

	Float(float f)
	{
		dosomik = f;
	}

	public void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <Exp> " + dosomik);
	}
}

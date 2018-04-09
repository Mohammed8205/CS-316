abstract class Exp
{
	abstract void printParseTree(String indent);

	abstract public void buildTypeMaps();

	abstract public TypeVal TypeEval();
}
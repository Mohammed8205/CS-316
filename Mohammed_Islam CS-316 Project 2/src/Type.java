
public class Type {
	
	int val;
	String token;
	
	public Type(int x){
		val = x;
	}
	
	public void setUp(){
		if( val == 1){
	
			token = "int";
		}
		if( val == 2){
	
			token = "float";
		}
		if( val == 3){
	
		token = "boolean";
		}
	}
	public void printParseTree(String indent){
		if( val == 1){
			IO.displayln(indent+indent.length()+ " <type> "+ "int");
			token = "int";
		}
		if( val == 2){
			IO.displayln(indent+indent.length()+ " <type> "+ "float");
			token = "float";
		}
		if( val == 3){
		IO.displayln(indent+indent.length()+ " <type> "+ "boolean");
		token = "boolean";
		}
	}
}

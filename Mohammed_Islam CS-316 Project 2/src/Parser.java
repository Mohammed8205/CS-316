
public abstract class Parser extends LexAnalyzer
{
	static boolean errorFound = false;

		
	public static FunDefList fundefList(){
		FunDef fn = fundef();
		if(state == State.Id || state == State.Keyword_float){
			FunDefList funList = fundefList();
			return new FunDefRepeat(fn,funList);
		}
		else {
		return fn;
		}
		
	}
	
	public static Header header(){
		if(state == State.Keyword_int || state == State.Keyword_float){
			Type ty = type();
			getToken();
			if(state == State.Id){
				FunName fn = funname();
				getToken();
				if(state == State.LParen){
					getToken();
					ParameterList  p = parameterList();
					if(state == State.RParen){
						return new Header(ty,fn,p);
					}
				}
				else if(state == State.Eq){
					
				}
				
			}
		}
		return null;
	}
	
	public static FunDef fundef(){
		Header h = header();
		Exp ex = null;
		getToken();
		if(state == State.Eq){
		ex = exp();
		return new FunDef(h,ex);
		}
		return null;
	}
	public static boolean khaisiTore = false;
	
	public static Exp exp(){
		if(!khaisiTore)
		getToken();
		System.out.println("From exp : "+t+" "+state.toString());
		switch ( state )
		{
			case Id:			
				Id id = new Id(t);
				return id;
			case Float:

				Float floatElem = new Float((float)Double.parseDouble(t));
				return floatElem;
	
			case Int:

				Int intElem = new Int(Integer.parseInt(t));
				return intElem;							
			case Keyword_false:
				BooleanLiteral bo = new BooleanLiteral(0);
				return bo;
			
			case Keyword_true:
				BooleanLiteral bo2 = new BooleanLiteral(1);
				return bo2;
				
			case LParen:
				ExpListFunExp fx = explistfunExp();
				return fx;
			case Keyword_else:
				Exp ex2 = exp();
				return ex2;
			case Keyword_then:
				Exp ex1 = exp();
				return ex1;
			case Keyword_if:
				Exp ex = exp();
				return ex;
				
			case RParen:
				getToken();
				return null;
			
			default:
				return null;
		}
	}
	
	
	
	private static ExpListFunExp explistfunExp() {
		FunExp fn = funexp();
		return new ExpListFunExp(fn);
	}

	public static FunExp funexp(){
		FunOp fo = funop();
		ExpList ex = explist();
		return new FunExp(fo,ex);
	}
	
	public static ExpList explist(){
		Exp ex = exp();
		if(ex == null)return new EmptyExpList();
		ExpList e = explist();
		return new ExpListRepeat(ex,e);
	}
	public static ParameterList parameterList(){
		Parameters pm = parameters();
		if(pm == null)return new ParamListIsEmpty();
		else{
			return new ParamListWithBracket(pm);
		}
	}
	public static FunOp funop(){
		getToken();
		if(state == State.Add){
			return new ArithOperation('+');
		}
		else if (state == State.Sub){
			return new ArithOperation('-');
		}
		else if (state == State.Mul){
			return new ArithOperation('*');
		}
		else if (state == State.Div){
			return new ArithOperation('/');
		}
		else if (state == State.Keyword_and){
			return new boolOperation("and");
		}
		else if (state == State.Keyword_or){
			return new boolOperation("or");
		}
		else if (state == State.Keyword_not){
			return new boolOperation("not");
		}
		else if (state == State.Gt){
			return new CompOp('>');
		}
		else if (state == State.Le){
			return new CompOp('<');
		}
		else if (state == State.Ge){
			return new CompOp(">=");
		}
		else if (state == State.Le){
			return new CompOp("<=");
		}
		else if (state == State.Eq){
			return new CompOp('=');
		}
		return null;
	}
	
	public static Parameters parameters(){
		Parameter  p = parameter();
		getToken();
		if(state == State.Comma){
			getToken();
			Parameters par = parameters();
			return new ParamListRepeat(p,par);
		}
		else if(state == State.RParen){
			return new SingleParam(p);
		}
		return null;
	}
	
	public static Parameter parameter(){
		Type ty = type();
		getToken();
		String x = t;
		return new Parameter(ty,x);
	}
	
	
	public static Type type(){
			if(t.compareToIgnoreCase("int") == 0){
				return new Type(1);
			}
			else if(t.compareTo("float") == 0){
				return new Type(2);
			}
			else
				return new Type(3);
	}
	
	public static FunName funname(){
		return new FunName(t);
	}
	
	public static void errorMsg(int i)
	{
		errorFound = true;
		
		display(t + " : Syntax Error, unexpected symbol where");

		switch( i )
		{
		case 1:	displayln(" arith op or ) expected"); return;
		case 2: displayln(" id, int, float, or ( expected"); return;
		case 3:	displayln(" = expected"); return;
		case 4:	displayln(" ; expected"); return;
		case 5:	displayln(" id expected"); return;		
		}
	}

	public static void main(String argv[])
	{		
		setIO( argv[0], argv[1] );
		setLex();

		getToken();

		FunDefList assignmentList = fundefList(); // build a parse tree
		if ( ! t.isEmpty() )
			errorMsg(5);
		else if ( ! errorFound ){
			assignmentList.printParseTree("");
		}
		closeIO();
	}
}

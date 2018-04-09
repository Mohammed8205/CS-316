
import java.util.HashMap;

/**
 
This class is a lexical analyzer for the tokens defined by the grammar:

<plus> --> +
<minus> --> -
<times> --> *
<div> --> /
<LParen> --> "("
<RParen> --> ")"
<int> --> { <digit> }+
<id> --> <letter> { <letter> | <digit> }
<float> --> { <digit> }+ "." { <digit> }+
<floatE> --> <float> (E|e) [+|-] { <digit> }+

This class implements a DFA that will accept the above tokens.

The DFA states are represented by the Enum type "State".
The DFA has the following 10 final states represented by enum-type literals:

state     token accepted

Id        identifiers
Int       integers
Float     floats without exponentiation part
FloatE    floats with exponentiation part
Plus      +
Minus     -
Times     *
Div       /
LParen    (
RParen    )

The DFA also uses the following 4 non-final states:

state      string recognized

Start      the empty string
Period     float parts ending with "."
E          float parts ending with E or e
EPlusMinus float parts ending with + or - in exponentiation part

The function "driver" operates the DFA. 
The function "nextState" returns the next state given the current state and the input character.

To recognize a different token set, modify the following:

  enum type "State" and function "isFinal"
  function "nextState" 

The functions "driver", "getToken" remain the same.

**/


public abstract class LexArith extends IO
{
	public enum State 
       	{ 
	  // non-final states     ordinal number

		Start,             // 0
		Period,            // 1
		E,                 // 2
		EPlusMinus,        // 3
	  // final states

		Id,                // 4
		Int,               // 5
		Float,             // 6
		FloatE,            // 7
		Plus,              // 8
		Minus,             // 9
		Times,             // 10
		Div,               // 11
		LParen,            // 12
		RParen,            // 13
		keyword_if,
		keyword_else,
		keyword_true,
		keyword_false,
		keyword_and,
		keyword_int,
		keyword_float,
		keyword_boolean,
		keyword_then,
		keyword_or,
		keyword_not,
		comma,
		gt,
		lt,
		ge,
		le,
		eq,
		
		UNDEF;

		private boolean isFinal()
		{
			return ( this.compareTo(State.Id) >= 0 );  
		}	
	}

	// By enumerating the non-final states first and then the final states,
	// test for a final state can be done by testing if the state's ordinal number
	// is greater than or equal to that of Id.

	// The following variables of "IO" class are used:

	//   static int a; the current input character
	//   static char c; used to convert the variable "a" to the char type whenever necessary

	public static String t; // holds an extracted token
	public static State state; // the current state of the FA
	public static HashMap<String,State> states = new HashMap<String,State>();

	private static int driver()

	// This is the driver of the FA. 
	// If a valid token is found, assigns it to "t" and returns 1.
	// If an invalid token is found, assigns it to "t" and returns 0.
	// If end-of-stream is reached without finding any non-whitespace character, returns -1.

	{
		State nextSt; // the next state of the FA

		t = "";
		state = State.Start;

		if ( Character.isWhitespace((char) a) )
			a = getChar(); // get the next non-whitespace character
		if ( a == -1 ){ // end-of-stream is reached
			return -1;
		}

		while ( a != -1 ) // do the body if "a" is not end-of-stream
		{
			c = (char) a;
			nextSt = nextState( state, c );
			if ( nextSt == State.UNDEF ) // The FA will halt.
			{
				if ( state.isFinal() ){
					if (state == State.Id){
						if(states.containsKey(t)){
							state = states.get(t);
						}
					}
				if(t.compareTo("+.") == 0)return 0;
				String temp = t;
				temp+= c;
				if(temp.compareTo("-.)") == 0) return 0;
				if(t.charAt(t.length()-1) == '_')return 0;
				if(t.compareTo("-.)") == 0) return 0;
				if(t.compareTo(".e") == 0)return 0;
					return 1; // valid token extracted
				}
				else // "c" is an unexpected character
				{
					t = t+c;
					a = getNextChar();
					return 0; // invalid token found
				}
			}
			else // The FA will go on.
			{
				state = nextSt;
				t = t+c;
				a = getNextChar();
			}
		}

		// end-of-stream is reached while a token is being extracted

		if ( state.isFinal() )
			return 1; // valid token extracted
		else
			return 0; // invalid token found
	} // end driver

	public static void getToken()

	// Extract the next token using the driver of the FA.
	// If an invalid token is found, issue an error message.

	{
		int i = driver();
		if ( i == 0 )
			displayln(t + " : Lexical Error, invalid token");
	}

	private static State nextState(State s, char c)

	// Returns the next state of the FA given the current state and input char;
	// if the next state is undefined, UNDEF is returned.

	{
		switch( state )
		{
		case Start:
			if ( Character.isLetter(c) )
				return State.Id;
			else if ( Character.isDigit(c) )
				return State.Int;
			else if ( c == '+' )
				return State.Plus;
			else if ( c == '-' )
				return State.Minus;
			else if ( c == '*' )
				return State.Times;
			else if ( c == '/' )
				return State.Div;
			else if ( c == '(' )
				return State.LParen;
			else if ( c == ')' )
				return State.RParen;
			else if (c == '.')
				return State.Float;
			else if (c == ',')
				return State.comma;
			else if (c == '<')
				return State.lt;
			else if (c == '>')
				return State.gt;
			else if (c == '=')
				return State.eq;
			else
				return State.UNDEF;
		case Id:
			if ( Character.isLetterOrDigit(c) || c == '_')
				return State.Id;
			else
				return State.UNDEF;
		case Int:
			if ( Character.isDigit(c) )
				return State.Int;
			else if ( c == '.' )
				return State.Float;
			else if (c == 'E' || c == 'e')
				return State.E;
			else
				return State.UNDEF;
		case Period:
			if ( Character.isDigit(c) )
				return State.Float;
			else
				return State.UNDEF;
		case Float:
			if ( Character.isDigit(c) )
				return State.Float;
			else if ( c == 'e' || c == 'E' )
				return State.E;
			else if (c == ')' && !valid())return State.RParen;
			else
				return State.UNDEF;
		case E:
			if ( Character.isDigit(c) )
				return State.FloatE;
			else if ( c == '+' || c == '-' && valid())
				return State.EPlusMinus;
			else
				return State.UNDEF;
		case EPlusMinus:
			if ( Character.isDigit(c) )
				return State.FloatE;
			else
				return State.UNDEF;
		case FloatE:
			if ( Character.isDigit(c) )
				return State.FloatE;
			else
				return State.UNDEF;
		case Plus:
			if(c == '.')return State.Float;
			else if(Character.isDigit(c))return State.Int;
			else return State.UNDEF;
		case keyword_if:
			if( c == 'f' && t.length() == 2)return State.keyword_if;
			else if(Character.isLetterOrDigit(c) && c != 'f')return State.Id;
			else return State.UNDEF;
		case keyword_else:
			if( c == 'e' && t.length() == 4)return State.keyword_else;
			else if(Character.isLetterOrDigit(c) && t.length()>=4)return State.Id;
			else return State.UNDEF;
		case lt:
			if (c == '=')return State.le;
			else return State.UNDEF;
		case gt:
			if (c == '=')return State.ge;
			else return State.UNDEF;
		case Minus:
			if (Character.isDigit(c) && c != '.')return State.Int;
			else if(c == '.')return State.Float;
			else return State.UNDEF;
		case RParen:
			return State.UNDEF;
		default:
			return State.UNDEF;
		}
	} // end nextState

	private static boolean valid() {
		for(int i = 0; i<t.length(); i++){
			if(Character.isDigit(t.charAt(i)))return true;
		}
		return false;
	}

	public static void main(String argv[])

	{		
		// argv[0]: input file containing source code using tokens defined above
		// argv[1]: output file displaying a list of the tokens 

		setIO( argv[0], argv[1] );
		
		setUpKeyWords(states);
		
		int i;

		while ( a != -1 ) // while "a" is not end-of-stream
		{
			i = driver(); // extract the next token
			if ( i == 1 ){
				if(states.containsKey(t)){
					state = states.get(t);
					displayln( t+"   : "+state.toString() );
				}
				else
				displayln( t+"   : "+state.toString() );
			}
			if ( i == 0 ){
				if(t.charAt(t.length()-1) != '_')
				displayln( t+" : Lexical Error, invalid token");
				else if (t.compareTo("_") != 0){
					display(t+"\n");
					displayln(" : Lexical Error, invalid token");
				}
				else if(t.compareTo("_") == 0){
					displayln( t+" : Lexical Error, invalid token");
				}
			}
		} 
		
		closeIO();
	}

	private static void setUpKeyWords(HashMap<String,State> keys) {
		keys.put("if", State.keyword_if);
		keys.put("else", State.keyword_else);
		keys.put("boolean", State.keyword_boolean);
		keys.put("true", State.keyword_true);
		keys.put("false", State.keyword_false);
		keys.put("int", State.keyword_int);
		keys.put("float", State.keyword_float);
		keys.put("then", State.keyword_then);
		keys.put("or", State.keyword_or);
		keys.put("not", State.keyword_not);
		keys.put("and", State.keyword_and);
	}
} 

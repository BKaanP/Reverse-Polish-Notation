package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

import java.util.Scanner;

public class Postfix {


	public static int importance(char x){

		if(x=='^'){
			return 2;
		}
		else if(x=='*' || x=='/'){
			return 1;
		}
		else if(x=='+' || x=='-'){
			return 0;
		}
		return -1;
	}


	public static void main(String[] args) throws Underflow {
		consoleInfixToPostfix();
	}
	public static void consoleInfixToPostfix() throws Underflow{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter you prefix expression: ");
		String postfix = infixToPostfix(scanner.nextLine());
		System.out.println("The corresponding postfix expression is: "+ postfix);
		System.out.println("The evaluation is: "+ evaluate(postfix));
	}

	public static String infixToPostfix(String infix) throws Underflow {
		// TODO Auto-generated method stub
		Stack<Character>stk= new LinkedListStack<>();
		//removing all whitespaces from string for easier process
		infix = infix.replaceAll(" ","");
		String ans="";
		for (int i = 0; i <infix.length() ; i++) {
			char x= infix.charAt(i);
			//Operator
			if(x>='0' && x<='9'){
				ans+=x;
			}
			//Special case for opening and closing bracket
			else if(x=='('){
				//push ( for easier ) handling
				stk.push('(');
			}else if(x==')'){
				//pop until ( is reached and then pop again to cut out ( inside stack
				while(!stk.isEmpty() && stk.top()!='('){
					ans+=stk.pop();
				}if(!stk.isEmpty()){
					stk.pop();
				}
			}
			//rest of string based on importance i.e. deciding if x = operator || operand
			else{
				while(!stk.isEmpty() && importance(stk.top())>=importance(x)){
					ans+=stk.pop();
				}
				stk.push(x);
			}
		}
		//final extraction of stack into resulting string
		while(!stk.isEmpty()){
			ans+=stk.pop();
		}
		//adding whitespaces and trimming for test case correction
		return ans.replaceAll(""," ").trim();
	}



	public static double evaluate(String postfix) throws Underflow {
		// TODO Auto-generated method stub
		//System.out.println(postfix.replaceAll(" ","").trim());
		Stack<Double> stk = new LinkedListStack<>();
		double cal = 0;
		postfix = postfix.replaceAll(" ","").trim();

		for(int i =0;i<postfix.length();i++){

			char x = postfix.charAt(i);
			//case switching for easier handling
			if(x=='+' || x=='-' || x=='*' || x=='/' || x=='^'){

				switch(x){
					case '+':
						cal = stk.pop();
						cal += stk.pop();
						stk.push(cal);
						break;
					case '-':
						cal = stk.pop();
						cal = stk.pop()-cal;
						stk.push(cal);
						break;
					case '*':
						cal = stk.pop();
						cal *= stk.pop();
						stk.push(cal);
						break;
					case '/':
						cal = stk.pop();
						cal = stk.pop()/cal;
						stk.push(cal);
						break;
					case '^':
						cal = stk.pop();
						cal = Math.pow(cal,stk.pop());
						stk.push(cal);
						break;
				}
			}else{
				stk.push((double) Character.getNumericValue(x));
			}
		}
		if(!stk.isEmpty()){
			return stk.pop();
		}

		return 0;
	}

}

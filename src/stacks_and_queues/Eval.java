package stacks_and_queues;

public class Eval {
	
	// converts infix to postfix and then evaluates that
	// adjusted for multiple digits
	public static void main(String args[]) {
		
		String infix = "1.0+41236*28.9*3.0-9*6/2.92";
		String[] splitInfix = convert(infix);
		String postfix = infix2Postfix(splitInfix);
		int result = evalPostfix(postfix);
		
		System.out.println(infix + " = " + postfix + " = " + result);
	}
	
	// converts to String[] using .split
	public static String[] convert(String infix) {
		String[] splitInfix = infix.split("([-+*/])");
	
//		for(int x = 0; x < splitInfix.length; x++) {
//			System.out.println(splitInfix[x]);
//		}
		return splitInfix;
	}
	
	public static String infix2Postfix(String[] splitInfix) {
		StackChar stack = new StackChar(splitInfix.length);
		String postfix = "";		// must be empty, no space
		
		for(int i = 0; i < splitInfix.length - 1; i++) {
			String s = splitInfix[i];
			if(isOperator(s)) {
				while((!stack.isEmpty()) && prec(s) <= prec(stack.top())) {
					postfix += stack.top();		stack.pop();
				}
				stack.push(s);
			} else {
				postfix += s;
			}
		}
		while(!stack.isEmpty()) {
			postfix += stack.top();		stack.pop();
		}
		return postfix;
	}
	
	public static int evalInfix(String[] splitInfix) {
		return evalPostfix(infix2Postfix(splitInfix)); 
	}
	
	public static int prec(String s) {
		if(s == "^")					return 3;
		if((s == "*") || (s == "/"))	return 2;
		if((s == "+") || (s == "-"))	return 1;
		else return 0;
	}
	
	public static int evalPostfix(String postfix) {
		// Stack stack = new Stack(postfix.length()/2 + 1); // using an array
		
		StackIntLL stack = new StackIntLL(); // using a linked list
		
		for(int i = 0; i < postfix.length(); i++) {
			String s = postfix;
		
			if(isOperator(s)) {
				int b = stack.top();	stack.pop();
				int a = stack.top();	stack.pop();
				
				if(s == "*") stack.push(a * b);
				if(s == "/") stack.push(a / b);
				if(s == "+") stack.push(a + b);
				if(s == "-") stack.push(a - b);
				
			} else {
				stack.push(s);
			}
		}
		return stack.top();
	}

	public static boolean isOperator(String s) {
		return (s == "*" || s == "/" || s == "+" || s == "-");
	}
}

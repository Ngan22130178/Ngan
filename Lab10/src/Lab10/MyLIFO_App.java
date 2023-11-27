package Lab10;


import java.util.Stack;

public class MyLIFO_App {
		public static void main(String[] args) {
				Integer[]array = {1, 2, 3};
				reserve(array);
				printArray(array);
				String input1 = "()(())[]{(())}";
		        String input2 = "){[]}()";

		        System.out.println("Input 1 is balanced: " + isCorrect(input1));
		        System.out.println("Input 2 is balanced: " + isCorrect(input2));
		        String expression = "51 + (54 * (3+2))";

		        System.out.println("Expression result: " + evaluateExpression(expression));
		}
	
		// This method reserves the given array
		public static <E> void reserve(E[] array) {
				Stack<E> re= new Stack<E>();
				for (E e : array) {
					re.push(e);
				}
				for (int i = 0; i < array.length; i++) {
		            array[i] = re.pop();
		        }
		}
		
		// This method checks the correctness of the given input
		// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
		public static boolean isCorrect(String input) {
			Stack<Character> stack = new Stack<>();

	        for (char ch : input.toCharArray()) {
	            if (ch == '(' || ch == '[' || ch == '{') {
	                // Opening bracket, push onto the stack
	                stack.push(ch);
	            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
	                // Closing bracket for '('
	                stack.pop();
	            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
	                // Closing bracket for '['
	                stack.pop();
	            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
	                // Closing bracket for '{'
	                stack.pop();
	            } else {
	                // Invalid character or mismatched brackets
	                return false;
	            }
	        }

	        // The input is balanced if the stack is empty at the end
	        return stack.isEmpty();
	
		}
		
		
		// This method evaluates the value of an expression
		// i.e. 51 + (54 *(3+2)) = 321

		    public static int evaluateExpression(String expression) {
		        Stack<Integer> operands = new Stack<>();
		        Stack<Character> operators = new Stack<>();

		        for (char ch : expression.toCharArray()) {
		            if (ch == ' ') {
		                // Skip whitespace
		                continue;
		            } else if (Character.isDigit(ch)) {
		                // If the character is a digit, parse the number and push onto the operands stack
		                int number = ch - '0';
		                while ((ch = expression.charAt(operands.size())) >= '0' && ch <= '9') {
		                    number = number * 10 + (ch - '0');
		                    operands.pop();
		                }
		                operands.push(number);
		            } else if (ch == '(') {
		                // Push opening parenthesis onto the operators stack
		                operators.push(ch);
		            } else if (ch == ')') {
		                // Evaluate expressions within parentheses
		                while (!operators.isEmpty() && operators.peek() != '(') {
		                    applyOperation(operands, operators.pop());
		                }
		                // Pop the opening parenthesis
		                operators.pop();
		            } else if (isOperator(ch)) {
		                // Process operators
		                while (!operators.isEmpty() && hasHigherPrecedence(ch, operators.peek())) {
		                    applyOperation(operands, operators.pop());
		                }
		                // Push the current operator onto the operators stack
		                operators.push(ch);
		            }
		        }

		        // Evaluate any remaining operators
		        while (!operators.isEmpty()) {
		            applyOperation(operands, operators.pop());
		        }

		        // The final result is on top of the operands stack
		        return operands.pop();
		    }

		    // Method to apply an operation to the operands stack
		    private static void applyOperation(Stack<Integer> operands, char operator) {
		        int operand2 = operands.pop();
		        int operand1 = operands.pop();
		        switch (operator) {
		            case '+':
		                operands.push(operand1 + operand2);
		                break;
		            case '-':
		                operands.push(operand1 - operand2);
		                break;
		            case '*':
		                operands.push(operand1 * operand2);
		                break;
		            case '/':
		                operands.push(operand1 / operand2);
		                break;
		        }
		    }

		    // Method to check if a character is an operator
		    private static boolean isOperator(char ch) {
		        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
		    }

		    // Method to check precedence of operators
		    private static boolean hasHigherPrecedence(char operator1, char operator2) {
		        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
		            return true;
		        }
		        return false;
		    }


		
		public static void printArray(Integer[] arr) {
	        for (int element : arr) {
	            System.out.print(element + " ");
	        }
	        System.out.println();
	    }
}

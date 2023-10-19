import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private Stack<Character> operatorStack;
    private Stack<Double> valueStack;
    private boolean error;

    public Calculator() {
        operatorStack = new Stack<>();
        valueStack = new Stack<>();
        error = false;
    }

    public double evaluate(String expression) {
        expression = preprocessExpression(expression);

        char[] characters = expression.toCharArray();

        for (int n = 0; n < characters.length; n++) {
            char ch = characters[n];
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder number = new StringBuilder();
                while (n < characters.length && (Character.isDigit(characters[n]) || characters[n] == '.')) {
                    number.append(characters[n]);
                    n++;
                }
                n--;
                double value = stringToDouble(number.toString());
                valueStack.push(value);
            } else if (isOperator(ch)) {
                processOperators(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                processClosingParenthesis();
            }
        }

        processRemainingOperators();

        if (!error) {
            if (valueStack.size() == 1 && operatorStack.isEmpty()) {
                return valueStack.pop();
            } else {
                error = true;
                System.out.println("Expression error.");
            }
        }
        return 0.0;
    }

    private String preprocessExpression(String expression) {
        expression = expression.trim().replaceAll("\\s+", "");
        expression = expression.replaceAll("(\\d)(\\()", "$1*$2");
        expression = expression.replace("(-", "(0-");
        return expression;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private double stringToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric value: " + str);
            error = true;
            return 0.0;
        }
    }

    private void processOperators(char currentOperator) {
        while (!operatorStack.isEmpty() && precedence(currentOperator) <= precedence(operatorStack.peek())) {
            char toProcess = operatorStack.pop();
            performOperation(toProcess);
        }
        operatorStack.push(currentOperator);
    }

    private int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private void performOperation(char operator) {
        if (valueStack.size() < 2) {
            System.out.println("Expression error.");
            error = true;
            return;
        }
        double b = valueStack.pop();
        double a = valueStack.pop();
        double result = 0;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Division by zero error.");
                    error = true;
                } else {
                    result = a / b;
                }
                break;
            default:
                System.out.println("Operator error.");
                error = true;
                break;
        }
        valueStack.push(result);
    }

    private void processClosingParenthesis() {
        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
            char toProcess = operatorStack.pop();
            performOperation(toProcess);
        }
        if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
            operatorStack.pop();
        } else {
            System.out.println("Error: unbalanced parenthesis.");
            error = true;
        }
    }

    private void processRemainingOperators() {
        while (!operatorStack.isEmpty()) {
            char toProcess = operatorStack.pop();
            if (toProcess == '(') {
                System.out.println("Error: unbalanced parenthesis.");
                error = true;
            } else {
                performOperation(toProcess);
            }
        }
    }

    public boolean hasError() {
        return error;
    }
    
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
   
       boolean continueCalculating = true;
   
       while (continueCalculating) {
           System.out.print("Enter a mathematical expression to compute: ");
           String userInput = input.nextLine();
   
           Calculator calculator = new Calculator();
           double result = calculator.evaluate(userInput);
   
           if (!calculator.hasError()) {
               System.out.println("The result is " + result);
           }
   
           System.out.print("Do you want to continue (yes/no)? ");
           String continueChoice = input.nextLine().trim().toLowerCase();
           if (!continueChoice.equals("yes")) {
               continueCalculating = false;
           }
       }
   
       System.out.println("Goodbye!");
   }
}
  

package recursion;

import java.util.Stack;

public class Parser {

    /**
     * Evaluate a mathematical expression represented as a string.
     * 
     * Specifications:
     * - Takes a mathematical expression as a string input (e.g., "3 + 5 * (2 - 8)").
     * - Removes spaces from the expression to simplify parsing.
     * - Calls the `parseExpression` method to process the expression and return the result.
     * - Handles the four basic arithmetic operators: +, -, *, /.
     * - Supports parentheses for operator precedence.
     * 
     * @param expression The mathematical expression to evaluate (e.g., "3 + 5 * (2 - 8)").
     * @return The result of the expression as a double.
     * @throws IllegalArgumentException If the expression contains mismatched parentheses or invalid characters.
     */
    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s+", ""); // Remove spaces
        return parseExpression(expression);
    }

    /**
     * Parse and evaluate the mathematical expression recursively.
     * 
     * Specifications:
     * - Uses two stacks: one for numbers (`values`) and one for operators (`operators`).
     * - Processes the expression character by character, handling numbers, operators, and parentheses.
     * - Handles nested expressions and operator precedence.
     * - Calls itself recursively to evaluate sub-expressions enclosed in parentheses.
     * 
     * @param expression The mathematical expression to parse.
     * @return The result of the parsed expression as a double.
     * @throws IllegalArgumentException If parentheses are mismatched or the expression contains invalid characters.
     */
    public static double parseExpression(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;

        while (i < expression.length()) {
            char current = expression.charAt(i);

            // If the character is a digit or a decimal point, build the number
            if (Character.isDigit(current) || current == '.') {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(number.toString()));
                continue; // Skip incrementing i as it's already handled
            } 
            // If the character is '(', recursively parse the sub-expression
            else if (current == '(') {
                int start = i;
                int brackets = 0;
                while (i < expression.length()) {
                    if (expression.charAt(i) == '(') brackets++;
                    if (expression.charAt(i) == ')') brackets--;
                    if (brackets == 0) break;
                    i++;
                }
                if (brackets != 0) {
                    throw new IllegalArgumentException("Mismatched parentheses in the expression.");
                }
                values.push(parseExpression(expression.substring(start + 1, i)));
            } 
            // If the character is an operator, handle precedence and apply operators
            else if ("+-*/".indexOf(current) != -1) {
                while (!operators.isEmpty() && precedence(current) <= precedence(operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(current);
            } 
            // If an invalid character is encountered, throw an exception
            else {
                throw new IllegalArgumentException("Invalid character in the expression: " + current);
            }
            i++;
        }

        // Apply remaining operators in the stack
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        // Return the result of the expression
        return values.pop();
    }

    /**
     * Determine the precedence of an operator.
     * 
     * Specifications:
     * - Defines operator precedence to ensure the correct order of operations.
     * - Higher values indicate higher precedence (multiplication/division have higher precedence than addition/subtraction).
     * 
     * @param operator The operator whose precedence is to be determined.
     * @return An integer representing the precedence of the operator (1 for +, -, and 2 for *, /).
     */
    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    /**
     * Apply an operator to two operands and return the result.
     * 
     * Specifications:
     * - Performs the arithmetic operation based on the operator and operands.
     * - Handles division by zero by throwing an exception.
     * - Only supports the operators: +, -, *, /.
     * 
     * @param operator The operator to apply.
     * @param b The second operand (the one on the right side of the operator).
     * @param a The first operand (the one on the left side of the operator).
     * @return The result of applying the operator to the operands.
     * @throws ArithmeticException If division by zero is encountered.
     * @throws IllegalArgumentException If the operator is unsupported.
     */
    public static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    /**
     * Main function for quick testing of the expression parser.
     * 
     * Specifications:
     * - This function demonstrates the use of the `evaluateExpression` method by evaluating a sample expression.
     * - Handles exceptions and prints error messages if any are thrown.
     * 
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        String expression = "3 + 5 * (2 - 8)";
        try {
            System.out.println("Result: " + evaluateExpression(expression));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

package Assignment2;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String sExpression = "(+ 2 (* 3 4) (- 5 2))";
        System.out.println("Result: " + evaluate(sExpression)); // Output: 15
    }

    public static int evaluate(String sExpression) {
        Stack<String> stack = new Stack<>();
        String[] tokens = sExpression.replace("(", " ( ").replace(")", " ) ").trim().split("\\s+");

        for (String token : tokens) {
            if (token.equals(")")) {
                // Evaluate the sub-expression
                List<String> expr = new ArrayList<>();
                while (!stack.peek().equals("(")) {
                    expr.add(0, stack.pop());
                }
                stack.pop(); // Remove "("
                stack.push(String.valueOf(evaluateSubExpression(expr)));
            } else {
                stack.push(token); // Push numbers, operators, or "("
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private static int evaluateSubExpression(List<String> expr) {
        String operator = expr.get(1);
        int result = operator.equals("+") || operator.equals("-") ? 0 : 1;

        for (int i = 1; i < expr.size(); i++) {
            int value = Integer.parseInt(expr.get(i));
            switch (operator) {
                case "+" -> result += value;
                case "-" -> result = (i == 1) ? value : result - value;
                case "*" -> result *= value;
                case "/" -> result = (i == 1) ? value : result / value;
            }
        }

        return result;
    }
}

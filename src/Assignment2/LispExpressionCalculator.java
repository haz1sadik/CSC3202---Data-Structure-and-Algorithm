package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class LispExpressionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter expression : ");
        String expression = input.nextLine();
        try {
            System.out.println("Result : " + evaluateExpression(expression));
        }catch (Exception e){
            System.out.println("Invalid Expression");
        }
    }
    public static double evaluateExpression(String expression){
        String[] separatedExpr = expression.replace("(", " ( ").replace(")", " ) ").trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for (String token : separatedExpr) {
            if (!token.equals(")")) {
                stack.push(token);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                while (!stack.peek().equals("(") && !stack.isEmpty()) {
                    temp.add(0, stack.pop());
                }
                stack.pop();

                String operator = temp.get(0);
                double result;
                    if (operator.equals("+") || operator.equals("-"))
                        result = 0;
                    else
                        result = 1;
                    for (int i = 1; i < temp.size(); i++) {
                        if (temp.size() == 2) {
                            result = Double.parseDouble(temp.get(1));
                            if (operator.equals("-")) {
                                result = -result;
                            }
                        } else {
                            double value = Double.parseDouble(temp.get(i));
                            switch (operator) {
                                case "+" -> result += value;
                                case "-" -> result = (i == 1) ? value : result - value;
                                case "*" -> result *= value;
                                case "/" -> result = (i == 1) ? value : result / value;
                            }
                        }
                    }
                stack.push(String.valueOf(result));
            }
        }
        return Double.parseDouble(stack.pop());
    }
}
package com.harsha.calculatorJavaAssessment.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.harsha.calculatorJavaAssessment.Operation;

public class ExpressionEvaluator {

    public List<Operation> createOperationListFromExpression(String expression) {
        List<Operation> operationList = new ArrayList<>();

        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operations = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {

                StringBuffer integerToken = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    integerToken.append(tokens[i++]);

                values.push(Integer.parseInt(integerToken.toString()));
            }

            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!operations.empty() && hasPrecedence(tokens[i], operations.peek()))
                    performOperationAndAppendToOperationList(values, operations, operationList);

                operations.push(tokens[i]);
            }
        }

        while (!operations.empty())
            performOperationAndAppendToOperationList(values, operations, operationList);

        return operationList;
    }

    // Evaluate the expression in left to right direction on custom numbers based
    // on rule that ( * or /) is higher priority than (+ or -)

    public Integer evaluateExpressionInCustomMode(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operations = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {

                StringBuffer integerToken = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    integerToken.append(tokens[i++]);

                values.push(getSignificantPartFromNumber(Integer.parseInt(integerToken.toString())));
            }

            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!operations.empty() && hasPrecedence(tokens[i], operations.peek()))
                    values.push(applyOperation(operations.pop(), values.pop(), values.pop()));

                operations.push(tokens[i]);
            }
        }

        while (!operations.empty())
            values.push(applyOperation(operations.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    // Evaluate the expression in left to right direction on numbers based
    // on rule that ( * or /) is higher priority than (+ or -)

    public Integer evaluateExpressionInDefaultMode(String expression) {

        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operations = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            else if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer integerToken = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    integerToken.append(tokens[i++]);

                values.push(Integer.parseInt(integerToken.toString()));

            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!operations.empty() && hasPrecedence(tokens[i], operations.peek()))
                    values.push(applyOperation(operations.pop(), values.pop(), values.pop()));

                operations.push(tokens[i]);
            }
        }
        while (!operations.empty())
            values.push(applyOperation(operations.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean hasPrecedence(char leftOperation, char rightOperation) {

        if ((leftOperation == '*' || leftOperation == '/') && (rightOperation == '+' || rightOperation == '-'))
            return false;
        else
            return true;
    }

    public static int applyOperation(char operation, int rightOperand, int leftOperand) {
        switch (operation) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                if (rightOperand == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return leftOperand / rightOperand;
        }
        return 0;
    }

    private Integer getSignificantPartFromNumber(Integer number) {

        int resultNumber = 1;
        while (Math.abs(number) > 9) {
            number /= 10;
            resultNumber *= 10;
        }
        resultNumber *= number;
        return resultNumber;
    }

    private void performOperationAndAppendToOperationList(Stack<Integer> values, Stack<Character> operations,
            List<Operation> operationList) {

        int leftOperand = values.pop();
        int rightOperand = values.pop();
        char operator = operations.pop();
        Operation operation = new Operation(leftOperand, rightOperand, Character.toString(operator));
        values.push(applyOperation(operator, leftOperand, rightOperand));
        operationList.add(operation);

    }
}
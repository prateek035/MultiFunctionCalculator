package com.harsha.calculatorJavaAssessment;

import com.harsha.calculatorJavaAssessment.logging.OperationsLogger;
import com.harsha.calculatorJavaAssessment.operators.Adder;
import com.harsha.calculatorJavaAssessment.operators.DefaultAdder;
import com.harsha.calculatorJavaAssessment.operators.DefaultDivider;
import com.harsha.calculatorJavaAssessment.operators.DefaultMultiplier;
import com.harsha.calculatorJavaAssessment.operators.DefaultSubtractor;
import com.harsha.calculatorJavaAssessment.operators.Divider;
import com.harsha.calculatorJavaAssessment.operators.ExpressionEvaluator;
import com.harsha.calculatorJavaAssessment.operators.Multiplier;
import com.harsha.calculatorJavaAssessment.operators.Subtractor;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;
    private LoggingStrategy loggingStrategy;
    private CalculationMode calculationMode;
    private List<Operation> operations;
    private OperationsLogger operationsLogger;

    public static class Builder {

        private Calculator calculator = new Calculator();

        public Calculator build() {
            // TODO validation
            calculator.operations = new ArrayList<>();
            if (calculator.adder == null)
                calculator.adder = new DefaultAdder();
            if (calculator.subtractor == null)
                calculator.subtractor = new DefaultSubtractor();
            if (calculator.multiplier == null)
                calculator.multiplier = new DefaultMultiplier();
            if (calculator.divider == null)
                calculator.divider = new DefaultDivider();
            if (calculator.calculationMode == null)
                calculator.calculationMode = CalculationMode.DEFAULT;

            return calculator;
        }

        public Builder adder(Adder adder) {
            // TODO
            calculator.adder = adder;
            return this;
        }

        public Builder subtractor(Subtractor subtractor) {
            // TODO
            calculator.subtractor = subtractor;
            return this;
        }

        public Builder multiplier(Multiplier multiplier) {
            // TODO
            calculator.multiplier = multiplier;
            return this;
        }

        public Builder divider(Divider divider) {
            // TODO
            calculator.divider = divider;
            return this;
        }

        public Builder calculationMode(CalculationMode calculationMode) {
            // TODO
            calculator.calculationMode = calculationMode;
            return this;
        }

        public Builder loggingStrategy(LoggingStrategy loggingStrategy) {
            // TODO
            calculator.loggingStrategy = loggingStrategy;
            return this;
        }
    }

    public Integer add(List<Integer> numbers) {
        // TODO Check mode, Add to operations

        for (int opCount = 0; opCount < numbers.size() - 1; opCount++) {
            Operation operation = new Operation(numbers.get(opCount), numbers.get(opCount + 1), " + ");
            operations.add(operation);
        }
        return adder.add(numbers);
    }

    public Integer subtract(Integer a, Integer b) {
        // TODO Check mode, Add to operations
        operations.add(new Operation(a, b, " - "));
        return subtractor.subtract(a, b);
    }

    public Integer multiply(List<Integer> numbers) {
        // TODO Check mode, Add to operations

        for (int opCount = 0; opCount < numbers.size() - 1; opCount++) {
            Operation operation = new Operation(numbers.get(opCount), numbers.get(opCount + 1), " * ");
            operations.add(operation);
        }
        return multiplier.multiply(numbers);
    }

    public Integer divide(Integer a, Integer b) {
        // TODO Check mode, Add to operations
        operations.add(new Operation(a, b, " / "));
        return divider.divide(a, b);
    }

    public void sendResults() {
        try {
            if (loggingStrategy == null)
                throw new Exception("Logging Strategy should be provided.");
            else
                operationsLogger.logOperations(operations, loggingStrategy);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public Integer calculate(String expression) {
        // TODO
        ExpressionEvaluator evaluator = new ExpressionEvaluator();

        for (Operation operation : evaluator.addOperationsFromExpression(expression)) {
            operations.add(operation);
        }

        switch (calculationMode) {
            case CUSTOM:
                return evaluator.evaluateExpressionInCustomMode(expression);

            default:
                return evaluator.evaluateExpressionInDefaultMode(expression);

        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
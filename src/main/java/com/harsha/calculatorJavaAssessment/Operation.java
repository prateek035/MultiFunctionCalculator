package com.harsha.calculatorJavaAssessment;

public class Operation {
    int leftOperand;
    int rightOperand;
    String operation;

    public Operation(int leftOperand, int rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Operation{" + "leftOperand=" + leftOperand + ", rightOperand=" + rightOperand + ", operation='"
                + operation + '\'' + '}';
    }

    public int getLeftOperand() {
        return this.leftOperand;
    }

    public int getRightOperand() {
        return this.rightOperand;
    }

    public String getOperation() {
        return this.operation;
    }
}

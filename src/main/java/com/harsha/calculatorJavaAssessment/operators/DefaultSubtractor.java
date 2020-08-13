package com.harsha.calculatorJavaAssessment.operators;

public class DefaultSubtractor implements Subtractor {

    @Override
    public Integer subtract(Integer a, Integer b) {

        long checkSubtractionResult = a;
        checkSubtractionResult -= b;

        try {
            if (checkSubtractionResult == (a - b))
                return (a - b);
            else
                throw new RuntimeException("Subtraction Invalid :: Integer Overflow");
        } catch (RuntimeException e) {

            System.out.println(e);
            return 0;
        }
    }
}

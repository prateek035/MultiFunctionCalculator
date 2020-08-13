package com.harsha.calculatorJavaAssessment.operators;

public class CustomSubtractor implements Subtractor {
    @Override
    public Integer subtract(Integer a, Integer b) {

        long checkSubtractionResult = getSignificantPartFromNumber(a);
        checkSubtractionResult -= getSignificantPartFromNumber(b);

        int subtractionResult = getSignificantPartFromNumber(a);
        subtractionResult -= getSignificantPartFromNumber(b);

        try {
            if (checkSubtractionResult == subtractionResult)
                return subtractionResult;
            else
                throw new RuntimeException("Subtraction Invalid :: Integer Overflow");
        } catch (RuntimeException e) {

            System.out.println(e);
            return 0;
        }
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
}
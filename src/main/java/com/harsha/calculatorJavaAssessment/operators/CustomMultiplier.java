package com.harsha.calculatorJavaAssessment.operators;

import java.util.List;

public class CustomMultiplier implements Multiplier {
    @Override
    public Integer multiply(List<Integer> numbers) {
        int multiplicationResult = 1;
        long checkMultiplicationResult = 1l;

        try {
            if (numbers.isEmpty())
                throw new Exception("Input List is Empty.");

            for (Integer number : numbers) {
                checkMultiplicationResult *= getSignificantPartFromNumber(number);
                multiplicationResult *= getSignificantPartFromNumber(number);

                if (checkMultiplicationResult != multiplicationResult)
                    throw new Exception("Integer Overflow");
            }

        } catch (Exception e) {

            e.printStackTrace();
            return 0;
        }
        return multiplicationResult;
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
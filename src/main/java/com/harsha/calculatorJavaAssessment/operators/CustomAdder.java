package com.harsha.calculatorJavaAssessment.operators;

import java.util.List;

public class CustomAdder implements Adder {
    @Override
    public Integer add(List<Integer> numbers) {

        int sum = 0;
        long checkAdditionResult = 0l;

        try {
            if (numbers.isEmpty())
                throw new Exception("Input List is Empty.");

            for (Integer number : numbers) {
                sum += getSignificantPartFromNumber(number);
                checkAdditionResult += getSignificantPartFromNumber(number);

                if (sum != checkAdditionResult)
                    throw new Exception("Integer Overflow");
            }

        } catch (Exception e) {

            e.printStackTrace();
            return 0;
        }

        return sum;
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

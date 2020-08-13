package com.harsha.calculatorJavaAssessment.operators;

import java.util.List;

public class DefaultAdder implements Adder {
    @Override
    public Integer add(List<Integer> numbers) {

        int sum = 0;
        long checkAdditionResult = 0l;

        try {
            if (numbers.isEmpty())
                throw new Exception("Input List is Empty.");

            for (Integer number : numbers) {
                sum += number;
                checkAdditionResult += number;

                if (sum != checkAdditionResult)
                    throw new Exception("Addition Invalid :: Integer Overflow");
            }

        } catch (Exception e) {

            e.printStackTrace();
            return 0;
        }

        return sum;
    }
}

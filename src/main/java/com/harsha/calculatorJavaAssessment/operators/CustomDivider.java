package com.harsha.calculatorJavaAssessment.operators;

public class CustomDivider implements Divider {
    @Override
    public Integer divide(Integer a, Integer b) {
        try {
            int newA = getSignificantPartFromNumber(a);
            int newB = getSignificantPartFromNumber(b);
            return newA / newB;

        } catch (Exception e) {

            System.out.println("*****Invalid Operation *****");
            e.printStackTrace();
            System.out.println("****************************");
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

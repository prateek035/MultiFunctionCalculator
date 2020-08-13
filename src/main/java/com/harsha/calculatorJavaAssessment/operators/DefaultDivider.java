package com.harsha.calculatorJavaAssessment.operators;

public class DefaultDivider implements Divider {

    @Override
    public Integer divide(Integer a, Integer b) {

        try {
            return a / b;

        } catch (Exception e) {

            System.out.println("*****Invalid Operation *****");
            e.printStackTrace();
            System.out.println("****************************");
            return 0;
        }
    }
}

package com.harsha.calculatorJavaAssessment;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.harsha.calculatorJavaAssessment.logging.fileCreator.CsvLogfileCreator;
import com.harsha.calculatorJavaAssessment.logging.fileCreator.DocxLogfileCreator;
import com.harsha.calculatorJavaAssessment.logging.fileCreator.TxtLogfileCreator;
import com.harsha.calculatorJavaAssessment.logging.notification.MailSender;
import com.harsha.calculatorJavaAssessment.logging.notification.Notification;
import com.harsha.calculatorJavaAssessment.operators.Adder;
import com.harsha.calculatorJavaAssessment.operators.CustomAdder;
import com.harsha.calculatorJavaAssessment.operators.CustomDivider;
import com.harsha.calculatorJavaAssessment.operators.CustomMultiplier;
import com.harsha.calculatorJavaAssessment.operators.CustomSubtractor;
import com.harsha.calculatorJavaAssessment.operators.DefaultAdder;
import com.harsha.calculatorJavaAssessment.operators.DefaultDivider;
import com.harsha.calculatorJavaAssessment.operators.DefaultMultiplier;
import com.harsha.calculatorJavaAssessment.operators.DefaultSubtractor;
import com.harsha.calculatorJavaAssessment.operators.Divider;
import com.harsha.calculatorJavaAssessment.operators.ExpressionEvaluator;
import com.harsha.calculatorJavaAssessment.operators.Multiplier;
import com.harsha.calculatorJavaAssessment.operators.Subtractor;
// import com.harsha.calculatorJavaAssessment.operators.CustomAdder;

public class Main {
    public static void main(String[] args) {

        // Adder myAddr = new CustomAdder();
        // Multiplier multiplier = new CustomMultiplier();
        // Divider divider = new CustomDivider();
        // Subtractor subtractor = new CustomSubtractor();
        // Calculator myCalc = new
        // Calculator.Builder().subtractor(subtractor).multiplier(multiplier).adder(myAddr)
        // .divider(divider).build();

        // Notification notification = new Notification();

        // notification.setMessage("Hello johny, How are you Doin.");
        // notification.setSubject("Testing -Application");
        // notification.setToAddress("nurav147@gmail.com");
        // notification.setFromAddress("mittalprateek999@gmail.com");
        // notification.setAttachment(fileCSV);
        // notification.setSignature("SDE:Zolostays");

        // MailSender mailer = new MailSender();

        // mailer.sendNotification(notification);

        // TxtLogfileCreator fileCreator = new TxtLogfileCreator();
        // DocxLogfileCreator fileCreator2 = new DocxLogfileCreator();
        // fileCreator.createLogFile(myCalc.operations);
        // fileCreator2.createLogFile(myCalc.operations);

        // System.out.println("File Created Success");

        // System.out.println("\n\n++++++++++++++++++++++++++++++++++++++\n\n");
        // // for (Operation operation : myCalc.operations) {
        // // System.out.println(operation);
        // // }
        // System.out.println("\n++++++++++++++++++++++++++++++++++++++\n");
        // System.out.println("Check Addition result : " + myCalc.add(Arrays.asList(1,
        // 2, 3, 4, 5, 15, 150, 250, 5008)));
        // System.out.println("Check subtraction result : " +
        // myCalc.subtract(2147483647, 9875));
        // System.out.println("Check Multi Result : " +
        // myCalc.multiply(Arrays.asList(582, 254)));
        // System.out.println("Check div result : " + myCalc.divide(880, 75));
        // myCalc.sendResults();
        // CsvLogfileCreator fileCreator3 = new CsvLogfileCreator();
        // File fileCSV = fileCreator3.createLogFile(myCalc.operations);

        // ExpressionEvaluator evaluator = new ExpressionEvaluator();

        // String expression = "48 * 845 / 20 - 65 / 42 + 32 / 16";

        // System.out.println("Custom Result:" +
        // evaluator.evaluateExpressionInCustomMode(expression));
        // System.out.println("Default Result:" +
        // evaluator.evaluateExpressionInDefaultMode(expression));
        // System.out.println(evaluator.createOperationListFromExpression(expression).toString());
        // myCalc.calculate(expression);
        // CsvLogfileCreator fileCreator3 = new CsvLogfileCreator();
        // File fileCSV = fileCreator3.createLogFile(myCalc.operations);

    }
}
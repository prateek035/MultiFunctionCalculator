package com.harsha.calculatorJavaAssessment;

import com.harsha.calculatorJavaAssessment.logging.OperationsLogger;
import com.harsha.calculatorJavaAssessment.operators.Adder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorBasicTest {

    @Mock
    OperationsLogger operationsLogger;

    @InjectMocks
    Calculator calculator;

    @Test
    public void basicTestInDefaultMode() {

        LoggingStrategy loggingStrategy = new LoggingStrategy("anyMail", FileFormat.csv);

        Calculator calculator = Calculator.builder().loggingStrategy(loggingStrategy).build();

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, -9);

        List<Operation> expectedListOfOperations = Arrays.asList(new Operation(1, 2, "+"), new Operation(3, 5, "+"),
                new Operation(8, -9, "+"));

        Integer sum = calculator.add(listOfNumbers);
        assertEquals("The calculator should return usual sum", -1, (int) sum);

    }

    @Test
    public void customiseAdditionWhenAdderIsProvidedTest() {

        LoggingStrategy loggingStrategy = new LoggingStrategy("anyMail", FileFormat.csv);
        Adder myAdder = numbers -> numbers.size(); // A lambda which means that myAdder is an instance of Adder with
                                                   // given behaviour
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, -9);

        Calculator calculator = Calculator.builder().adder(myAdder).calculationMode(CalculationMode.CUSTOM)
                .loggingStrategy(loggingStrategy).build();

        // Addition behavior should be as specified by myAdder
        Integer sum = calculator.add(listOfNumbers);
        assertEquals("The calculator should return size of numbers passed as specified by myAdder", 4, (int) sum);

        // Multiplication behavior should remain same
        Integer product = calculator.multiply(listOfNumbers);
        assertEquals("The multiplication behavior should remain same", -90, (int) product);

    }
}

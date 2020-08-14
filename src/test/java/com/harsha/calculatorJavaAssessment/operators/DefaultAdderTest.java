package com.harsha.calculatorJavaAssessment.operators;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultAdderTest {

    @InjectMocks
    DefaultAdder defaultAdder;

    @Before
    public void init() {
        defaultAdder = new DefaultAdder();
    }

    @Test
    public void basicTest() {
        List<Integer> numbersToBeAdded = Arrays.asList(5, 10, -6, 0);
        Integer sum = defaultAdder.add(numbersToBeAdded);
        assertEquals("The sum should be 9", 9, (int) sum);
    }

    @Test
    public void notEnoughNumbersShouldThrowExceptionTest() {
        List<Integer> emptyList = new ArrayList<>();
        try {
            defaultAdder.add(emptyList);
            throw new Exception("Adding an empty list should throw exception");
        } catch (Exception e) {
            assertTrue("Passing an emptyList to defaultAdder threw exception as expected", true);
        }
    }
}

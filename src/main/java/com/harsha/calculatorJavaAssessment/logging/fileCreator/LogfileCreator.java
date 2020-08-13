package com.harsha.calculatorJavaAssessment.logging.fileCreator;

import com.harsha.calculatorJavaAssessment.Operation;

import java.io.File;
import java.util.List;

public interface LogfileCreator {

    File createLogFile(List<Operation> operations);
}

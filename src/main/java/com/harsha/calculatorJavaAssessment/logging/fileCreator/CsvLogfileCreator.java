package com.harsha.calculatorJavaAssessment.logging.fileCreator;

import com.harsha.calculatorJavaAssessment.Operation;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvLogfileCreator implements LogfileCreator {
    @Override
    public File createLogFile(List<Operation> operations) {
        try {

            File file = generateEmptyCsvFile();
            CSVWriter writer = new CSVWriter(new FileWriter(file));

            String heading[] = { "LeftOperand", "RightOperand", "Operation" };
            writer.writeNext(heading);

            for (Operation operation : operations) {
                String leftOperand = Integer.toString(operation.getLeftOperand());
                String rightOperand = Integer.toString(operation.getRightOperand());
                String operator = operation.getOperation();

                String line[] = { leftOperand, rightOperand, operator };
                writer.writeNext(line);
            }
            writer.flush();
            return file;

        } catch (Exception e) {

            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
        return null;
    }

    private File generateEmptyCsvFile() throws IOException {

        String fileName = "CsvLogFile" + ".csv";
        File file = new File(fileName);
        while (file.isFile() && file.exists()) {
            int rand = (int) (Math.random() * (1000 - 10)) + 10;
            fileName = "CsvLogFile-" + rand + ".csv";
            file = new File(fileName);
        }
        file.createNewFile();
        return file;
    }
}

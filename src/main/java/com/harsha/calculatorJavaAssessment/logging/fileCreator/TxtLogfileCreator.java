package com.harsha.calculatorJavaAssessment.logging.fileCreator;

import com.harsha.calculatorJavaAssessment.Operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtLogfileCreator implements LogfileCreator {

    @Override
    public File createLogFile(List<Operation> operations) {
        try {
            File file = generateEmptyTextFile();
            FileWriter myWriter = new FileWriter(file);
            for (Operation operation : operations) {
                myWriter.write(operation.toString());
                myWriter.write("\n");
            }
            myWriter.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File generateEmptyTextFile() throws IOException {

        String fileName = "TextLogFile" + ".txt";
        File file = new File(fileName);
        while (file.isFile() && file.exists()) {
            int rand = (int) (Math.random() * (1000 - 10)) + 10;
            fileName = "TextLogFile-" + rand + ".txt";
            file = new File(fileName);
        }
        file.createNewFile();
        return file;
    }
}

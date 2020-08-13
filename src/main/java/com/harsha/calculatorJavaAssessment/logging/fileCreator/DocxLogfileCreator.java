package com.harsha.calculatorJavaAssessment.logging.fileCreator;

import com.harsha.calculatorJavaAssessment.Operation;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DocxLogfileCreator implements LogfileCreator {
    @Override
    public File createLogFile(List<Operation> operations) {

        try {
            File file = generateEmptyDocxFile();
            FileOutputStream myFileStream = new FileOutputStream(file);

            XWPFDocument document = new XWPFDocument();
            XWPFParagraph title = document.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun titleRun = title.createRun();
            titleRun.setText("Operation Logs");

            XWPFTable table = document.createTable();
            for (Operation operation : operations) {
                table.createRow().getCell(0).setText(operation.toString());
            }

            document.write(myFileStream);
            document.close();
            myFileStream.close();
            return file;

        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }

        return null;
    }

    private File generateEmptyDocxFile() throws IOException {

        String fileName = "DocxLogFile" + ".docx";
        File file = new File(fileName);
        while (file.isFile() && file.exists()) {
            int rand = (int) (Math.random() * (1000 - 10)) + 10;
            fileName = "DocxLogFile-" + rand + ".docx";
            file = new File(fileName);
        }
        file.createNewFile();
        return file;
    }
}

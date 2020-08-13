package com.harsha.calculatorJavaAssessment;

public class LoggingStrategy {
    String email;
    FileFormat fileFormat;

    public LoggingStrategy(String email, FileFormat fileFormat) {
        this.email = email;
        this.fileFormat = fileFormat;
    }

    public String getEmail() {
        return this.email;
    }

    public FileFormat getFileFormat() {
        return this.fileFormat;
    }

}

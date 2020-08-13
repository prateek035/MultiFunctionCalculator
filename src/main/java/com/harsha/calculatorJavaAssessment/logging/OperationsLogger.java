package com.harsha.calculatorJavaAssessment.logging;

import com.harsha.calculatorJavaAssessment.FileFormat;
import com.harsha.calculatorJavaAssessment.LoggingStrategy;
import com.harsha.calculatorJavaAssessment.Operation;
import com.harsha.calculatorJavaAssessment.logging.fileCreator.LogfileCreator;
import com.harsha.calculatorJavaAssessment.logging.fileCreator.LogfileCreatorFactory;
import com.harsha.calculatorJavaAssessment.logging.notification.MailSender;
import com.harsha.calculatorJavaAssessment.logging.notification.Notification;
import com.harsha.calculatorJavaAssessment.logging.notification.NotificationsSender;

import java.io.File;
import java.util.List;

public class OperationsLogger {

    LogfileCreator logfileCreator;

    NotificationsSender notificationsSender;

    public OperationsLogger() {
    }

    private LogfileCreator getLogfileCreator(FileFormat fileFormat) {
        if (logfileCreator == null) {
            logfileCreator = LogfileCreatorFactory.create(fileFormat);
        }
        return logfileCreator;
    }

    private NotificationsSender getNotificationsSender() {
        if (notificationsSender == null) {
            notificationsSender = new MailSender();
        }
        return notificationsSender;
    }

    public void logOperations(List<Operation> operations, LoggingStrategy loggingStrategy) {
        // TODO get logfile creator instance and create file
        logfileCreator = getLogfileCreator(loggingStrategy.getFileFormat());
        // TODO create an instance of Notification

        File resultFile = logfileCreator.createLogFile(operations);
        Notification notification = new Notification();

        notification.setMessage("Please find the Operation File attached with the mail.");
        notification.setSubject("PFA : Operation File Result");
        notification.setToAddress(loggingStrategy.getEmail());
        notification.setFromAddress("senderToEmail@gmail.com");
        notification.setAttachment(resultFile);
        notification.setSignature("Thanks and Regards");

        // TODO Obtain an instance of notification sender and send notification
        notificationsSender.sendNotification(notification);
    }
}

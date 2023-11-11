package com.amcsoftware.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amcsoftware.setup.Enums.LoggingLevel;

public class LogUtility {

    public static Logger logger = LoggerFactory.getLogger("log");

    public LogUtility() {
    }

    public static void startTestCase(String testName) {
        if(!testName.isEmpty()) {
            String msg = String.format("************* Starting Test: %s ****************", testName);
            logger.info(msg);
            System.out.println(msg);
        }
    }

    public static void endTestCase(String testName) {
        if(!testName.isEmpty()) {
            String msg = String.format("************* Ending Test: %s ****************", testName);
            logger.info(msg);
        }
    }

    public static void logInfo(String method, String message) {
        String statement = String.format("%s%s - %s", "Method - ", method, message);
        logger.info(statement);
    }

    public static void logInfo(String message) {
        logInfo(generateCallingMethodName(), message);
    }

    public static void logWarning(String method, String message) {
        String statement = String.format("%s%s - %s", "Method - ", method, message);
        logger.warn(statement);
    }

    public static void logError(String method, String message) {
        String statement = String.format("%s%s - %s", "Method - ", method, message);
        logger.error(statement);
    }

    public static void logError(String message) {
        logError(generateCallingMethodName(), message);
    }

    public static void logDebug(String method, String message) {
        String statement = String.format("%s%s - %s", "Method - ", method, message);
        logger.debug(statement);
    }

    public static void logException(String method, Exception e, LoggingLevel logLevel, Boolean writeToConsole) {
        writeToConsole = writeToConsole != null ? writeToConsole : false;
        printException(method, null, e, logLevel);
        if(writeToConsole) {
            System.err.println("Failure in method: " + method + ". Exception: " + e);
        }
    }

    public static void logException(String method, String message, Exception e, LoggingLevel logLevel, Boolean writeToConsole) {
        writeToConsole = writeToConsole != null ? writeToConsole : false;
        printException(method, message, e, logLevel);
        if(writeToConsole) {
            System.err.println("Failure in method: " + method + ". Exception: " + e);
        }
    }

    public static void logException(String method, Throwable output, LoggingLevel logLevel, Boolean writeToConsole) {
        writeToConsole = writeToConsole != null ? writeToConsole : false;
        printThrowable(method, (String)null,output, logLevel);
        if(writeToConsole) {
            System.err.println("Failure in method: " + method + ". Exception: " + output);
        }
    }

    public static void logException(String method, String message, Throwable output, LoggingLevel logLevel, Boolean writeToConsole) {
        writeToConsole = writeToConsole != null ? writeToConsole : false;
        printThrowable(method, message, output, logLevel);
        if(writeToConsole) {
            System.err.println("Failure in method: " + method + ". Exception: " + output);
        }
    }

    public static void printException(String method, String message, Exception e, LoggingLevel logLevel) {
        message = message == null ? "" : message;
        String statement = String.format("Failure in method: %s occurred %s Exception: %s", method, message, e);
        switch (logLevel) {
            case INFO -> logger.info(statement);
            case DEBUG -> logger.debug(statement);
            case ERROR -> logger.error(statement);
            case WARN -> logger.warn(statement);
            default -> logger.debug(statement);
        }
    }

    public static void printThrowable(String method, String message, Throwable output, LoggingLevel logLevel) {
        message = message != null ? "" : message;
        String statement = String.format("Failure in method: %s occurred %s Exception: %s", method, message, output);
        switch (logLevel) {
            case INFO -> logger.info(statement);
            case DEBUG -> logger.debug(statement);
            case ERROR -> logger.error(statement);
            case WARN -> logger.warn(statement);
            default -> logger.debug(statement);
        }
    }

    public static String generateCallingMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
}

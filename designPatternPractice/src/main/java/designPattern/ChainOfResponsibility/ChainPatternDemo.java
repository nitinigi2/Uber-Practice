package designPattern.ChainOfResponsibility;

public class ChainPatternDemo {

    public static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Logger logger = getChainOfLoggers();

        logger.logMessage(Logger.INFO, "This is info level");
        logger.logMessage(Logger.DEBUG, "This is debug log");
        logger.logMessage(Logger.ERROR, "This is error log");
    }
}

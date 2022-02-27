package src.com.java8practice;

public class ChainOfResponsiblity {
    
    private static Logger doChaining() {
        Logger consoleLogger = new ConsoleBasedLogger(Logger.OUTPUT_INFO);

        Logger errorLogger = new ErrorBasedLogger(Logger.ERROR_INFO);
        consoleLogger.setNextLevelLogger(errorLogger);

        Logger debugLogger = new DebugBasedLogger(Logger.DEBUG_INFO);
        errorLogger.setNextLevelLogger(debugLogger);

        return consoleLogger;
    }

    public static void main(String args[]) {
        Logger chainLogger = doChaining();

        chainLogger.logMessage(Logger.OUTPUT_INFO, "Enter the sequence of values ");
        chainLogger.logMessage(Logger.ERROR_INFO, "An error is occurred now");
        chainLogger.logMessage(Logger.DEBUG_INFO, "This was the error now debugging is completed");
    }
}

abstract class Logger {
    public static int OUTPUT_INFO = 1;
    public static int ERROR_INFO = 2;
    public static int DEBUG_INFO = 3;
    protected int levels;
    protected Logger nextLevelLogger;

    public void setNextLevelLogger(Logger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(int levels, String msg) {
        if (this.levels < levels) {
            displayLogInfo(msg);
        }

        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(levels, msg);
        }
    }

    protected abstract void displayLogInfo(String msg);
}

class ConsoleBasedLogger extends Logger {
    public ConsoleBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("CONSOLE LOGGER INFO: " + msg);
    }
}

class DebugBasedLogger extends Logger {
    public DebugBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("DEBUG LOGGER INFO: " + msg);
    }
}

class ErrorBasedLogger extends Logger {
    public ErrorBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("ERROR LOGGER INFO: " + msg);
    }
}

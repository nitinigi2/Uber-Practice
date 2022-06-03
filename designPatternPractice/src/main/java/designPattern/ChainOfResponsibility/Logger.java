package designPattern.ChainOfResponsibility;

public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    protected int level;
    private Logger nextLogger;

    public void setNextLogger(Logger logger) {
        this.nextLogger = logger;
    }

    public void logMessage(int level, String message) {
        if(this.level >= level) {
            write(message);
        }
        if(nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

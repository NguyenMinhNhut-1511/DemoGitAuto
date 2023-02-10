package project.genarals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    //Initialize Log4j instance
    private static final Logger Log =  LogManager.getLogger(Log.class);

    //Info
    public static void info (String message) {
        Log.info(message);
    }
    public static void info (Object object) {
        Log.info(object);
    }

    //Warn
    public static void warn (String message) {
        Log.warn(message);
    }
    public static void warn (Object object) {
        Log.warn(object);
    }

    //Error
    public static void error (String message) {
        Log.error(message);
    }
    public static void error (Object object) {
        Log.error(object);
    }

    //Debug
    public static void debug (String message) {
        Log.debug(message);
    }
    public static void debug (Object object) {
        Log.debug(object);
    }
}

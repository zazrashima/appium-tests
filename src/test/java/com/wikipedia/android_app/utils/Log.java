package com.wikipedia.android_app.utils;
import com.relevantcodes.extentreports.LogStatus;
import com.wikipedia.android_app.utils.ExtentReports.ExtentTestManager;
import org.apache.log4j.Logger;
public class Log {

    //Initialize Log4j instance
    private static final Logger Log = Logger.getLogger(Log.class.getName());

    //We can use it when starting tests
    public static void startLog (String testClassName){
        Log.info("Test is Starting...");
    }

    //We can use it when ending tests
    public static void endLog (String testClassName){
        Log.info("Test is Ending...");
    }

    //Info Level Logs
    public static void info (String message) {
        ExtentTestManager.getTest().log(LogStatus.INFO, message);
        Log.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        ExtentTestManager.getTest().log(LogStatus.WARNING, message);
        Log.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        ExtentTestManager.getTest().log(LogStatus.ERROR, message);
        Log.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        ExtentTestManager.getTest().log(LogStatus.FATAL, message);
        Log.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }
}
package com.wikipedia.android_app.utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy-HH_mm_ss");
            Date date = new Date();
            extent = new ExtentReports(workingDir + File.separator + "ExtentReports"
                    + File.separator + String.format("ExtentReportResults-%s.html",formatter.format(date)), false);
        }
        return extent;
    }
}

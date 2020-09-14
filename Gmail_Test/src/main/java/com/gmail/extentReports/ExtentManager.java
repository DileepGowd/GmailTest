package com.gmail.extentReports;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * 
 * @author dileep s
 *
 */
public class ExtentManager {

	private static ExtentReports extent;
	
	public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            extent = new ExtentReports(System.getProperty("user.dir")+"/ExtentReportResults.html", true);
        }
        return extent;
    }

}

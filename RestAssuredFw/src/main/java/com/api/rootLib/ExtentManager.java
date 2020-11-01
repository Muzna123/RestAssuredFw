package com.api.rootLib;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static String reportFilename="Test.Execution-Report"+".html";
	public static ExtentReports getInstance() {
		if(extent==null)
			createInstance();
		return extent;
	} 
	//Create an extent report instance
	public static ExtentReports createInstance() {
		Date d=new Date();
		String currentTime=d.toString();
		currentTime=currentTime.replaceAll(" ", "").replaceAll(":", "");
		//String filename=getReportPath(reportFilename);
		reportFilename=reportFilename+currentTime;
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./TestReport/test-Report"+currentTime+".html");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFilename);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFilename);
		htmlReporter.config().setTimeStampFormat("EEEE , MMMM dd, yyyy, hh.mm á'('zzz')'");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		//set Environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "Gaurav");
		return extent;
		
	}
}
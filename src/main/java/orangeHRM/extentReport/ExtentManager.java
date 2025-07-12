package orangeHRM.extentReport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	 public static final ExtentReports extentReports = new ExtentReports();
	 
	    public synchronized static ExtentReports createExtentReports() {
	    	
	    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/extent-reports "+timeStamp+".html");
	        reporter.config().setReportName("OrangeHRM Test Automation Report");
	        reporter.config().setTheme(Theme.DARK);
	        reporter.config().setDocumentTitle("OrangeHRM Website Test Automation Result");
	        extentReports.attachReporter(reporter);
	        extentReports.setSystemInfo("Author", "Dhanalakshmi J");
	        return extentReports;
	        
	    }
	
}

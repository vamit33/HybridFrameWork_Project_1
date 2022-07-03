package Com.Base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.Utilities.PropertiesUtils;

public class BaseClass {

	public static WebDriver driver = null;
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	public static ExtentSparkReporter sparkReporter = null;

	public static void initialization() throws Exception {
		System.out.println("initializing browser"); //Only console--Temporary
		log.info("initializing browser"); // File as well as console

		String browsername = PropertiesUtils.readProperty("browser");

		if (browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.readProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	public void reportInit() {
		
		report = new ExtentReports();
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReports.html");
		
		report.attachReporter(sparkReporter);
		
	}
}

package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {	
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("We Automation Result");
	reporter.config().setDocumentTitle("Test Results");
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ramesh K");
	}
	@Test
	public void initialDemo()
	{
	extent.createTest("initial Demo");
	System.setProperty("webdriver.chrome.driver", "src/main/java/WebDrivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	extent.flush();
	}
}

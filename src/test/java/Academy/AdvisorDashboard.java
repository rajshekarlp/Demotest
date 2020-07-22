package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AdvisorDashboard {
	ExtentReports extent;
	@BeforeTest
	public void config()
	{

	//ExtentReports , ExtentSparkReporter
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter =new ExtentSparkReporter(path);
	reporter.config().setReportName("3ACC Automation Report");
	reporter.config().setDocumentTitle("Test Results");
	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Parampal Brar");
	}

	@Test
	public void reppicker()
	{
	extent.createTest("Rep");
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/WebDrivers/chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.get("https://rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	extent.flush();
	}

}

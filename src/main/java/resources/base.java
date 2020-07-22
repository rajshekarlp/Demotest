package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{	
  prop= new Properties();
  FileInputStream fis=new FileInputStream("src/main/java/resources/data.properties");
  prop.load(fis);
  String browserName=prop.getProperty("browser");
  //String browserName=System.getProperty("browser");
  System.out.println(browserName);
  if(browserName.equals("chrome"))
  {
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/WebDrivers/chromedriver.exe");
	 driver= new ChromeDriver();
	//execute in chrome driver	
   }
   else if (browserName.equals("firefox"))
   {
	   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/WebDrivers/geckodriver.exe"); 
	 driver= new FirefoxDriver();
	//firefox code
    }
    else if (browserName.equals("Safari"))
    {
      //	Safari code
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
}
public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
	//String png= System.currentTimeMillis()+ ".png";
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
}
}

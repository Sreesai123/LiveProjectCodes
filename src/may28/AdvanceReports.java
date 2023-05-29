package may28;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class AdvanceReports {
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	@BeforeTest
	public void generateReport()
	{
		report = new ExtentReports("./reports/Demo.html");
	}
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void passTest()
	{
		logger = report.startTest("Test Pass");
		logger.assignAuthor("Sree");
		logger.assignCategory("Function1");
		String expected = "google";
		String actual = driver.getTitle();
		if (expected.equalsIgnoreCase(actual)) 
		{
			logger.log(LogStatus.PASS,"Title is matching::"+expected+"     "+actual);
		}
		else
		{
			logger.log(LogStatus.PASS,"Title is not matching::"+expected+"     "+actual);	
		}
	}
	@Test
	public void failTest()
	{
		logger = report.startTest("Test fail");
		logger.assignAuthor("Sree");
		logger.assignCategory("Function1");
		String expected = "gmail";
		String actual = driver.getTitle();
		if (expected.equalsIgnoreCase(actual)) 
		{
			logger.log(LogStatus.FAIL,"Title is matching::"+expected+"     "+actual);
		}
		else
		{
			logger.log(LogStatus.FAIL,"Title is not matching::"+expected+"     "+actual);	
		}
	}	
	@AfterTest
	public void tearDown()
	{
		report.endTest(logger);
		report.flush();
		report.close();
	}
}


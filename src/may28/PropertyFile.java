package may28;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertyFile {
	Properties con;
	WebDriver driver;
	@BeforeTest
	public void setUp() throws Throwable
	{
		con = new Properties();
		con.load(new FileInputStream("E:\\11oclock_Selenium\\LiveProjectCodes\\Loginproperties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(con.getProperty("Url"));
	}
	@Test

	public void login()

	{

		driver.findElement(By.xpath(con.getProperty("ObjResetbtn"))).click();

		driver.findElement(By.xpath(con.getProperty("ObjUser"))).sendKeys(con.getProperty("EnterUser"));

		driver.findElement(By.xpath(con.getProperty("ObjPass"))).sendKeys(con.getProperty("Enterpass"));

		driver.findElement(By.xpath(con.getProperty("ObjLoginbtn"))).click();

		String expected ="Dashboard « Stock Accounting";

		String actual =driver.getTitle();

		if(expected.equalsIgnoreCase(actual))

		{

			Reporter.log("Title is Matching::"+expected+"   "+actual);

		}

		else

		{

			Reporter.log("Title is Not Matching::"+expected+"   "+actual);

		}

	}

	@AfterTest

	public void tearDown()

	{

		driver.close();

	}
}

package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		// ternary operator, result=testcondition ? value1 : value2
		String browser = browser_maven != null ? browser_maven : browser_properties;
		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			}
			if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				driver.manage().window().maximize();	
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.get(URL);
		}

		return driver;

	}

}

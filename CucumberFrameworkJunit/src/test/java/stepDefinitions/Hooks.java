package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;



import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import utils.TestContextSetup;

public class Hooks {

	TestContextSetup testcontextsetup;

	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}

	@After
	public void AfterScenario() throws IOException {
		testcontextsetup.testbase.WebDriverManager().quit();
		

	}
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver=testcontextsetup.testbase.WebDriverManager();
		if(scenario.isFailed())
		{
			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent = FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(filecontent, "image/png", "image");
			
		}
		
	}

}

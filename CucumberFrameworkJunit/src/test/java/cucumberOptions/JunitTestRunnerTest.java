package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//dryRun=true, 
//tags= "@placeorder",
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",glue = "stepDefinitions",  monochrome = true, plugin = {
		"pretty", "html:target/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_Scenarios.txt" })
public class JunitTestRunnerTest   {

}

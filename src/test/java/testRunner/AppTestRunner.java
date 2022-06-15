package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/CurrencyConverterAppTest.feature",
		glue = {"stepDefination","TestHooks"},stepNotifications = true,
		plugin ={"pretty","json:target/cucumber/Cucumber.json","html:target/cucumber/cucumber-html-report.html"},monochrome = true,
		tags = "@Smoke"
		)
public class AppTestRunner extends AbstractTestNGCucumberTests {

}

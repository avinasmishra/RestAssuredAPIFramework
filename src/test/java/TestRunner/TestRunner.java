package TestRunner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		plugin = "json:target/jsonReport/cucumber-report.json",
		glue = {"stepDefinations"}
		//tags = "@DeletePlace"
		)
public class TestRunner {

}

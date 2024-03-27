package cucumber_Gherkin;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features="C:\\Users\\FINCART\\eclipse-workspace\\Testing\\features.feature",glue= {"cucumber_Gherkin"},
	plugin= {"pretty","json:target/kk/cucumber-reports.json"}
	)
	public class Step_Definition {
}

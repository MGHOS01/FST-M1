package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
//    tags = "@activity1_1",    
    monochrome = true,
    plugin = {"html: test-reports"}
)

public class ActivitiesRunner {
    //empty
}

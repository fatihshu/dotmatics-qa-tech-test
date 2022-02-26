package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue={"steps"},
        tags="@technical-test",
        stepNotifications=false,
        plugin = {"json:target/output.json"}
)

public class ScenarioRunner {
}

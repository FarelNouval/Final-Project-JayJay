package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:web",
        glue = {"web", "hooks"},
        plugin = {
                "pretty",
                "html:reports/web-cucumber-report.html",
                "json:reports/web-cucumber-report.json"
        },
        tags = "@web"
)
public class WebTestRunner {
}

package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:api",
        glue = {"api"},
        plugin = {
                "pretty",
                "html:reports/api-cucumber-report.html",
                "json:reports/api-cucumber-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@api"
)
public class ApiTestRunner {
}
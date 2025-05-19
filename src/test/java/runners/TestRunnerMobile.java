package runners;

import mobile.driver.DriverInitializer;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/features/mobile"},
                glue = {"steps"},
                tags = ("@Mobile_Regression"),
                plugin =
                        {
                                "pretty",
                                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                        }
        )


public class TestRunnerMobile extends DriverInitializer {
}
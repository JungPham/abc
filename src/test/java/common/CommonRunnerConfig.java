package common;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ReportHelper;

@CucumberOptions(
        glue = {"utils",
                "common"},
        plugin = {"pretty", "summary",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber.json"})

public class CommonRunnerConfig extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"url", "browser"})
    public void init(String url, String browser) {
        System.setProperty("browser", browser);
        System.setProperty("url", url);
    }

    @AfterSuite(alwaysRun = true)
    public void generateHTMLReports() {
        ReportHelper.generateCucumberReport();
    }
}

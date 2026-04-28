package org.prog.session15;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session15.page.GooglePage;
import org.prog.session15.steps.DBSteps;
import org.prog.session15.steps.WebAtomicSteps;
import org.prog.session15.steps.WebSteps;
import org.prog.session15.util.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.SQLException;

@CucumberOptions(
        tags = "@all_in_one",
        glue = "org.prog.session15.steps",
        features = "src/test/resources/features"
)
@Slf4j
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException, MalformedURLException {
        driver = WebDriverFactory.getDriver();
        DBSteps.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
        DBSteps.statement = DBSteps.connection.createStatement();
        WebSteps.googlePage = new GooglePage(driver);
        WebAtomicSteps.driver = driver;
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        driver.quit();
        DBSteps.connection.close();
    }
}

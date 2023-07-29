package StepDefinition;

import DataDriven.JSonDataReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;

public class Hooks {
    public static WebDriver driver ;
    JSonDataReader Reader = new JSonDataReader();
    @Before
    public void openUrl() throws IOException, ParseException {
        if (driver==null){
            driver= new ChromeDriver();
        }
        Reader.jsonReader();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(Reader.url);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit(); // Use quit() to close the entire browser session.
            driver = null; // Reset the driver to null to signify that the session is closed.
        }
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed ScreenShot", new ByteArrayInputStream(screenshot));

        }
    }
}

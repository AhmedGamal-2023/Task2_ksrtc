package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static StepDefinition.Hooks.driver;

public class HomePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    private final By specificRouteLocator = By.xpath("//a[contains(., 'Chikkamagaluru - Bengaluru')]");
    private final By SliderLocator = By.id("routeSlider");
    private final By NextLocator  =By.cssSelector("a[title='Next']");
    private final By DayLocator  =By.xpath("//a[contains(text(),'30')]");
    private final By SearchLocator  =By.xpath("//button[contains(text(),'Search for Bus')]");



    public void chooseFromPopularRoutes(){
        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(SliderLocator));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", slider);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(specificRouteLocator))).click();
    }
    public void chooseArrivalDate(){
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(NextLocator))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(DayLocator))).click();
    }
    public void ClickSearchForBus(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SearchLocator))).click();
    }
}

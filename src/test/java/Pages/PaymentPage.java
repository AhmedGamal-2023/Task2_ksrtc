package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static StepDefinition.Hooks.driver;

public class PaymentPage {
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30)) // Maximum time to wait
            .pollingEvery(Duration.ofSeconds(2)) // Polling interval
            .ignoring(org.openqa.selenium.NoSuchElementException.class);
    private final By ContentLocator = By.cssSelector("div[id='modal']");
    private final By CardLocator = By.cssSelector("button[method='card']");
    private final By Card_numberLocator = By.cssSelector("input[id='card_number']");
    private final By card_expiryLocator = By.cssSelector("button[method='card_expiry']");
    private final By card_nameLocator = By.cssSelector("input[id='card_name']");
    private final By card_cvvLocator = By.cssSelector("input[id='card_cvv']");
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void FillsInformation(String cardNumber,String card_expiry,String Name,String card_cvv){
        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(ContentLocator));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", slider);
        WebElement cardElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(CardLocator));
        js.executeScript("arguments[0].click();", cardElement);



        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Card_numberLocator))).sendKeys(cardNumber);
        driver.findElement(card_expiryLocator).sendKeys(card_expiry);
        driver.findElement(card_nameLocator).sendKeys(Name);
        driver.findElement(card_cvvLocator).sendKeys(card_cvv);


    }
}

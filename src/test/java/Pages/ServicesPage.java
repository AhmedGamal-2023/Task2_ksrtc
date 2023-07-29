package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static StepDefinition.Hooks.driver;

public class ServicesPage {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private  Select select ;

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    private final By SelectSeatLocator = By.cssSelector("input#SrvcSelectBtnForward0");
    private final By BoardingPointLocator = By.cssSelector("li[class='p-2 Forward-boarding active1']");
    private final By DroppingPointLocator = By.cssSelector("li[class='p-2 Forward-droping active1']");
    private final By mobileLocator = By.cssSelector("input[name='mobileNo']");
    private final By EmailLocator = By.cssSelector("input[name='email']");
    private final By seatLocator = By.cssSelector("li.availSeatClassS[title='33(W,S)']");
    private final By passengerNameLocator = By.cssSelector("input[name='passengerName']");
    private final By passengerAgeLocator = By.cssSelector("input[name='passengerAge']");
    private final By genderLocator = By.cssSelector("select[name='genderCodeId']");
    private final By concessionLocator = By.cssSelector("select[name='concessionIds']");
    private final By MakePaymentLocator = By.cssSelector("input[title='Make Payment']");


    public void SelectSeat(){
        WebElement selectSeatsButton = driver.findElement(SelectSeatLocator);

        // Use JavaScriptExecutor to click on the hidden element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", selectSeatsButton);    }
    public void ChooseBoardingAndDropping(String Mobile,String Email){
        WebElement Boarding = wait.until(ExpectedConditions.visibilityOfElementLocated(BoardingPointLocator));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Boarding);
        Boarding.click();

        driver.findElement(DroppingPointLocator).click();
        driver.findElement(mobileLocator).sendKeys(Mobile);
        driver.findElement(EmailLocator).sendKeys(Email);
        driver.findElement(seatLocator).click();

     }
     public void FillCustomerAndPassengerDetails(String Name,String Age){
         driver.findElement(passengerNameLocator).sendKeys(Name);
         driver.findElement(passengerAgeLocator).sendKeys(Age);

         WebElement GenderElement = driver.findElement(genderLocator);
         select =new Select(GenderElement);
         select.selectByVisibleText("MALE");

         WebElement concessionElement = driver.findElement(concessionLocator);
         select =new Select(concessionElement);
         select.selectByVisibleText("GENERAL PUBLIC");


     }
     public void ClickMakePayment(){
         WebElement MakePayment = wait.until(ExpectedConditions.visibilityOfElementLocated(MakePaymentLocator));
         js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", MakePayment);
         MakePayment.click();
     }

}

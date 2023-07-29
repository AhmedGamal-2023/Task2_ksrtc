package StepDefinitions;

import DataDriven.JSonDataReader;
import Pages.HomePage;
import Pages.PaymentPage;
import Pages.ServicesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Step1 {
    JSonDataReader Reader = new JSonDataReader();
    SoftAssert soft = new SoftAssert();
    private HomePage home =new HomePage();
    private ServicesPage services =new ServicesPage();
    private PaymentPage payment =new PaymentPage();
    @Given("Choose the following from CHIKKAMAGALURU to BENGALURU from the popular routes")
    public void chooseFromPopularRoutes(){
    home.chooseFromPopularRoutes();
    }
    @When("Choose the arrival date only")
    public void chooseArrivalDate(){
        home.chooseArrivalDate();
    }
    @And("Click Search for bus")
    public void ClickSearchForBus(){
        home.ClickSearchForBus();
    }
    @And("Select a seat")
    public void SelectSeat(){
     services.SelectSeat();
    }
    @And("Choose the boarding point and dropping point")
    public void ChooseBoardingAndDropping() throws IOException, ParseException {
        Reader.jsonReader();
     services.ChooseBoardingAndDropping(Reader.Mobile, Reader.Email);
    }
    @And("Fill the “Customer” and Passenger details")
    public void FillCustomerAndPassengerDetails() throws IOException, ParseException {
        Reader.jsonReader();
        services.FillCustomerAndPassengerDetails(Reader.Name, Reader.Age);
    }
    @Then("Click on make payment and fill all the fields without submitting the payment")
    public void ClickMakePaymentAndFills(){
        services.ClickMakePayment();
    }
}

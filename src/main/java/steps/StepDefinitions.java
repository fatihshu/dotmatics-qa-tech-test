package steps;

import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.EventPageObjectModel;
import java.util.List;


public class StepDefinitions extends EventPageObjectModel {
    // private static RemoteWebDriver remoteWebDriver ;
//    @Before
//    public static void before(Scenario scenario) {
//       // Write code to Set this.remoteWebDriver to a new RemoteWebDriver instance to talk to a Selenium Chrome Server of your choice
//    }
//
//    @After
//    public static void after(Scenario scenario) {
//
//        //StepDefinitions.remoteWebDriver.close();
//    }

//    @Given("I navigate to URL {string}")
//    public static void iNavigateToURL(String url) {
//        StepDefinitions.remoteWebDriver.navigate().to(url);
//    }
//    // Write more Steps as necessary to perform the tests
//}

    JavascriptExecutor js=(JavascriptExecutor)Driver.get();


    @Given("I navigate to URL {string}")
    public void i_navigate_to_url(String url) {
        Driver.get().get(url);

    }

    @Then("I should login successfully to Event  page")
    public void i_should_login_successfully_to_event_page() {
        String expectedURL="https://www.dotmatics.com/events";
        Assert.assertEquals(expectedURL,Driver.get().getCurrentUrl());
    }

    @Then("I should clicks on {string} view on the page")
    public void i_should_clicks_on_view_on_the_page(String expetedModule) throws InterruptedException {
        Thread.sleep(2000);
        clickListGridCalender("List");

    }

    @Then("I should filter Event by following options")
    public void i_should_filter_event_by_following_options(List<String> expectedOption) throws InterruptedException {

        js.executeScript("arguments[0].click();",filterByButton);
        Thread.sleep(2000);
        sortedByOnline.click();


    }

    @Then("I should see a list of one or more events")
    public void i_should_see_a_list_of_one_or_more_events() {



    }

    @Then("I should select first event seen in the Results")
    public void i_should_select_first_event_seen_in_the_results()  {

        //selectOnlineEvent.click();
       // String actualEvent="SmartLab Digital 2022";


    }

    @Then("I should print the Date and Time of this event")
    public void i_should_print_the_date_and_time_of_this_event()  {

       // System.out.println(datePrintforOnline.getText());

    }

}

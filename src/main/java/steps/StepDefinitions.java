package steps;

import Utilities.ConfigurationReader;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.EventPageObjectModel;
import java.util.concurrent.TimeUnit;


public class StepDefinitions extends EventPageObjectModel {

    private static RemoteWebDriver remoteWebDriver ;

    public static RemoteWebDriver get() {
        if (remoteWebDriver == null) {
            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    remoteWebDriver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    remoteWebDriver = new FirefoxDriver();
                    break;
            }
        }
        return remoteWebDriver;
    }

    public static void closeDriver () {
        if (remoteWebDriver != null) {
            remoteWebDriver.quit();
            remoteWebDriver = null;
        }
    }

   @Before
   public static void before(Scenario scenario) {

      get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     get().manage().window().maximize();

   }

    @After
    public static void after(Scenario scenario) {
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        closeDriver();
    }


    @Given("I navigate to URL {string}")
    public void i_navigate_to_url(String url) {
       get().get(url);

    }

    @Then("I should login successfully to Event  page")
    public void i_should_login_successfully_to_event_page() {

   String expectedURL="https://www.dotmatics.com/events";
   Assert.assertEquals(expectedURL,get().getCurrentUrl());
    }

    @Then("I should clicks on {string} view on the page")
    public void i_should_clicks_on_view_on_the_page(String expectedModule) {

    clickListGridCalender(expectedModule);
    }

    @Then("I should filter Event by {string}")
    public void i_should_filter_event_by(String expectedBy)  {

       clickWithJS(filterByButton);
       clickSortByOption(expectedBy);


    }

    @Then("I should see a list of one or more events")
    public void i_should_see_a_list_of_one_or_more_events() {

    }

    @Then("I should select first event seen in the Results")
    public void i_should_select_first_event_seen_in_the_results()  {

        clickSelectEvent("online event list");


    }

    @Then("I should print the Date and Time of this event")
    public void i_should_print_the_date_and_time_of_this_event()  {

        System.out.println(printDateTime(dateTimeLink));

    }

}

package pages;

import Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class EventPageObjectModel {

    public EventPageObjectModel(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='js-toggle-btn-out']")
    public WebElement filterByButton;

    @FindBy(xpath = "//ul[@class='js-toggle-block-out']/li")
    public List<WebElement>sortedByAllEventsLinks;

    @FindBy(xpath = "//li[@class='_orange']")
    public WebElement sortedByIndustryEvent;

    @FindBy(xpath = "//div[@class='l-news-item _orange ']")
    public List<WebElement>selectIndustryEvents;

    @FindBy(xpath = "//li[@class='_dark-blue']")
    public WebElement sortedByOnline;

    @FindBy(xpath = "(//h4)[3]")
    public WebElement selectOnlineEvent;

    @FindBy(xpath = "//h2")
    public WebElement verifySelectedOnlineEvent;

    @FindBy(xpath = "")
    public WebElement datePrintforOnline;


    public void clickListGridCalender(String module) {
        String moduleLink = " //i[@class='icon-" + module + "']";
        try {
            Driver.get().findElement(By.xpath(moduleLink.toLowerCase())).click();
        } catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(Driver.get().findElement(By.xpath(moduleLink.toLowerCase()))));
        }
    }



    public void filterByAllEvents(String option){
      switch (option){

            case "All":
                sortedByAllEventsLinks.get(0).click();
                break;
            case "Dotmatics Event":
                sortedByAllEventsLinks.get(1).click();
                break;
            case "Industry Event":
                sortedByAllEventsLinks.get(2).click();

                break;
            case "Online":
                sortedByAllEventsLinks.get(3).click();
                break;
            case "Training":
                sortedByAllEventsLinks.get(4).click();
                break;
        }
    }







//    public  List<String> getFilterby() {
//        List<String> elemTexts = new ArrayList<>();
//        for (WebElement el :allEventsLinks ) {
//            elemTexts.add(el.getText());
//        }
//        return elemTexts;
//    }
//

//
//    public void DateTimeforOnlineEvent(String onlineDateTime) {
//        String onlineEventDateTime ="//i[@class='icon-"+onlineDateTime+"']";
//        Driver.get().findElement(By.xpath(onlineEventDateTime.toLowerCase())).getText();
//    }


//public static List<String> displayedEventBy(String option) {
//    if (option.equals("Online")) {
//        String onliEventLists = "(//div[@class='l-news-tag'])[2]";
//        Driver.get().findElement(By.xpath(onliEventLists)).getText();
//    }
//

}





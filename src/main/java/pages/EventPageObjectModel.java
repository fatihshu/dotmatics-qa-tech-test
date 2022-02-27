package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.StepDefinitions;
import java.util.ArrayList;
import java.util.List;

public class EventPageObjectModel {

    public EventPageObjectModel(){

        PageFactory.initElements(StepDefinitions.get(), this);
    }

    @FindBy(xpath = "//div[@class='events-filter-select']/div")
    public WebElement filterByButton;

    @FindBy(xpath = "//li[@class='_orange']")
    public WebElement sortedByIndustryEvent;

    @FindBy(xpath = "//div[@class='l-news _list']/div")
    public List<WebElement> selectIndustryEvents;

    @FindBy(xpath = "//li[@class='_dark-blue']")
    public WebElement sortedByOnline;

    @FindBy(partialLinkText = "SmartLab Digital 2022")
    public WebElement selectOnlineEvent;


    @FindBy(xpath = "//ul[@class='info-row-about']/li")
    public List<WebElement> dateTimeLink;


    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) StepDefinitions.get())
                .executeScript("arguments[0].click();", element);
    }

    public void clickListGridCalender(String module) {
        String element = " //i[@class='icon-" + module.trim().toLowerCase()+ "']";
        WebElement girdListCalender=StepDefinitions.get().findElement(By.xpath(element));
        clickWithJS(girdListCalender);

        }

    public void clickSortByOption(String option){
        switch (option.trim().toLowerCase()) {
            case "industry event":
                clickWithJS(sortedByIndustryEvent);
                break;
            case "online":
                clickWithJS(sortedByOnline);
                break;
        }
    }


    public void clickSelectEvent(String option){
        switch (option.trim().toLowerCase()) {
            case "industry event list":
                clickWithJS(selectIndustryEvents.get(4));
              break;
            case "online event list":
                clickWithJS(selectOnlineEvent);
                break;
        }
    }


 public  List<String> printDateTime(List<WebElement>dateTimeLink) {
     List<String> elemTexts = new ArrayList<>();
     for (WebElement el : dateTimeLink) {
         elemTexts.add(el.getText());
     }
     return elemTexts;
 }
}


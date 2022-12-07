package pageobject.itera.pages;

import io.cucumber.java.eo.Se;
import model.survey.Survey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobject.BaseFunc;

import java.util.List;

public class MainPage {
    private Survey survey = new Survey();

    private final By NAME = By.xpath(".//input[contains(@id, 'name')]");
    private final By MOBILE_NUMBER = By.xpath(".//input[contains(@id, 'phone')]");
    private final By EMAIL = By.xpath(".//input[contains(@id, 'email')]");
    private final By PASSWORD = By.xpath(".//input[contains(@id, 'password')]");
    private final By ADDRESS = By.xpath(".//textarea[contains(@id, 'address')]");
    private final By GENDER = By.xpath(".//input[contains(@type, 'radio') and contains(@name, 'optionsRadios')]");
    private final By DAY_OF_WEEK = By.xpath(".//input[contains(@type, 'checkbox') and contains(@id, 'day')]");
    private final By COUNTRY = By.xpath(".//select[contains(@class, 'custom-select')]");
    private final By XP_YEARS = By.xpath(".//label[contains(@class, 'custom-control') and contains(@for, 'year')]");
    private final By AUTO_TOOLS = By.xpath(".//label[contains(@class, 'custom-control') and contains(@for, '')]");
//    .//div[contains(@class, 'custom-control custom-checkbox')]




    private BaseFunc baseFunc;

    public MainPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public MainPage insertCredentials() {
        baseFunc.type(NAME, survey.setName());
        baseFunc.type(MOBILE_NUMBER, survey.setMobilenumber());
        baseFunc.type(EMAIL, survey.setEmail());
        baseFunc.type(PASSWORD, survey.setPassword());
        baseFunc.type(ADDRESS, survey.setAddress());
        return this;
    }

    public void selectGender() {
        List<WebElement> getgenders = baseFunc.findElements(GENDER);
        for (WebElement selectgender : getgenders) {
            String nameOfTheGender = selectgender.getAttribute("id");
            if (nameOfTheGender.equals("male"))
            {
                selectgender.click();
            }
        }
    }

    public void selectDayOfTheWeek() {
        List<WebElement> getwholeWeek = baseFunc.findElements(DAY_OF_WEEK);
        for (WebElement selecteddayofweek : getwholeWeek) {
            String nameOfTheDay = selecteddayofweek.getAttribute("id");
            if (nameOfTheDay.equals("monday") || (nameOfTheDay.equals("tuesday") || (nameOfTheDay.equals("thursday"))))
            {
                selecteddayofweek.click();
            }
        }
    }

    public void selectCountry() {
        WebElement getCountrys = baseFunc.findElement(COUNTRY);
        Select selectingCountry = new Select(getCountrys);
        selectingCountry.selectByVisibleText("Italy");
    }

    public void selectYears() {
        List<WebElement> getYear = baseFunc.findElements(XP_YEARS);
        for (WebElement yearsxp : getYear) {
            String selectNumberOfYears = yearsxp.getAttribute("for");
            if (selectNumberOfYears.equals("3years"))
            {
                yearsxp.click();
            }
        }

    }

    public void selectTool() {
        List<WebElement> getTools = baseFunc.findElements(AUTO_TOOLS);
        for (WebElement theTools : getTools) {
            String selectNumberOfYears = theTools.getAttribute("for");
            if (selectNumberOfYears.equals("selenium"))
            {
                theTools.click();
            }
        }
    }
    
}

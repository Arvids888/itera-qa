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
    private final By XP_YEARS = By.xpath(".//input[contains(@type, 'radio') and contains(@id, 'year')]");


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
        List<WebElement> genders = baseFunc.findElements(GENDER);
        for (WebElement selectgender : genders) {
            String nameOfTheGender = selectgender.getAttribute("id");
            if (nameOfTheGender.equals("male"))
            {
                selectgender.click();
            }
        }
    }

    public void selectDayOfTheWeek() {
        List<WebElement> wholeWeek = baseFunc.findElements(DAY_OF_WEEK);
        for (WebElement selecteddayofweek : wholeWeek) {
            String nameOfTheDay = selecteddayofweek.getAttribute("id");
            if (nameOfTheDay.equals("monday") || (nameOfTheDay.equals("tuesday") || (nameOfTheDay.equals("thursday"))))
            {
                selecteddayofweek.click();
            }
        }
    }

    public void selectCountry() {
        WebElement selectCountry = baseFunc.findElement(COUNTRY);
        Select selectingCountry = new Select(selectCountry);
        selectingCountry.selectByVisibleText("Italy");
    }

    public void selectYears() {
        List<WebElement> selectYear = baseFunc.findElements(XP_YEARS);
        for (WebElement yearsxp : selectYear) {
            String selectNumberOfYears = yearsxp.getAttribute("id");
            if (selectNumberOfYears.equals("3years"))
            {
                yearsxp.click();
            }
        }

    }
}

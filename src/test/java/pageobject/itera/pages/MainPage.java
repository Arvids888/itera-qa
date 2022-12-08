package pageobject.itera.pages;

import io.cucumber.java.eo.Se;
import model.survey.Survey;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobject.BaseFunc;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.sql.Driver;
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
    private final By FILE = By.xpath("//input[contains(@type, 'file')]");
    private final By SUBMIT = By.xpath(".//button[contains(@name, 'submit')]");






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

    public void selectGender(String gender) {
        List<WebElement> getgenders = baseFunc.findElements(GENDER);
        for (WebElement selectgender : getgenders) {
            String nameOfTheGender = selectgender.getAttribute("id");
            if (nameOfTheGender.equals(gender))
            {
                selectgender.click();
            }
        }
    }

    public void selectDayOfTheWeek(String day) {
        List<WebElement> getwholeWeek = baseFunc.findElements(DAY_OF_WEEK);
        for (WebElement selecteddayofweek : getwholeWeek) {
            String nameOfTheDay = selecteddayofweek.getAttribute("id");
            if (nameOfTheDay.equals(day))
            {
                selecteddayofweek.click();
            }
        }
    }

    public void selectCountry(String country) {
        WebElement getCountrys = baseFunc.findElement(COUNTRY);
        Select selectingCountry = new Select(getCountrys);
        selectingCountry.selectByVisibleText(country);
    }

    public void selectYears(String years) {
        List<WebElement> getYear = baseFunc.findElements(XP_YEARS);
        for (WebElement yearsxp : getYear) {
            String selectNumberOfYears = yearsxp.getAttribute("for");
            if (selectNumberOfYears.equals(years))
            {
                yearsxp.click();
            }
        }

    }

    public void selectTool(String tool) {
        List<WebElement> getTools = baseFunc.findElements(AUTO_TOOLS);
        for (WebElement theTools : getTools) {
            String selectNumberOfYears = theTools.getAttribute("for");
            if (selectNumberOfYears.equals(tool))
            {
                theTools.click();
            }
        }
    }

    public void selectFile(String path) throws AWTException {
        baseFunc.findUploadElement(FILE).sendKeys(path);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", button);
////        button.sendKeys("C:\\Users\\Double A\\Pictures\\Itera cat.jpg");
//
//        Robot rb = new Robot();
//        rb.delay(2000);
//
//        StringSelection ss = new StringSelection("C:\\Users\\Double A\\Pictures\\Itera cat.jpg");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

    }

    public void submit() {
        baseFunc.findElement(SUBMIT).click();
    }
}

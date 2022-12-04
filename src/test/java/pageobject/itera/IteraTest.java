package pageobject.itera;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageobject.BaseFunc;
import pageobject.itera.pages.MainPage;

public class IteraTest {
    private final String URL = "itera-qa.azurewebsites.net/home/automation";

    private BaseFunc baseFunc = new BaseFunc();

    @BeforeEach
    public void openWebPage() {

    }

    @Test
    public void checkSurvey() {
        baseFunc.openPage(URL);
        MainPage mainPage = new MainPage(baseFunc);

        mainPage.insertCredentials();
        mainPage.selectGender();
        mainPage.selectDayOfTheWeek();
        mainPage.selectCountry();
        mainPage.selectYears();


    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}

package pageobject.itera;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageobject.BaseFunc;
import pageobject.itera.pages.MainPage;

import java.awt.*;

public class IteraTest {
    private final String URL = "itera-qa.azurewebsites.net/home/automation";

    private BaseFunc baseFunc = new BaseFunc();

    @BeforeEach
    public void openWebPage() {

    }

    @Test
    public void checkSurvey() throws AWTException {
        baseFunc.openPage(URL);
        MainPage mainPage = new MainPage(baseFunc);

        mainPage.insertCredentials();
        mainPage.selectGender("male");
        mainPage.selectDayOfTheWeek("friday");
        mainPage.selectCountry("Italy");
        mainPage.selectYears("3years");
        mainPage.selectTool("selenium");
        mainPage.selectFile("C:\\\\Iteracat.jpg");
        mainPage.submit();



    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}

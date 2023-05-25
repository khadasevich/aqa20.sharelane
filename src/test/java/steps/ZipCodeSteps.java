package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.classicpageobject.ZipCodePage;

public class ZipCodeSteps {
    private static ZipCodePage zipCodePage;

    @Step("User inputs zipcode and proceed")
    public static void validateZipcode(WebDriver driver, String zipCode) {
        //В шаги собираются действия из страниц в определенный флоу
        zipCodePage = new ZipCodePage(driver);
        zipCodePage.openRegisterPage();
        zipCodePage.inputZipCode(zipCode);
        zipCodePage.clickContinue();
    }
}

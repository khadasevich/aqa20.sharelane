package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.classicpageobject.SignUpFormPage;
import pages.classicpageobject.ZipCodePage;
import utilities.TestDataGenerator;

@Epic("User management")
@Feature("Registration")
@Story("Zip code page")
@Tag("sharelane")
public class ZipCodeClassicalPomTest extends BaseTest {

    @Test(description = "Go through zip step of registration")
    @Description("Go through zip step of registration")
    @Issue("LRRC-209")
    @TmsLink("TMS-156")
    @Severity(SeverityLevel.BLOCKER)
    public void zipCodeTest() {
        ZipCodePage zipCodePage = new ZipCodePage(driver);
        zipCodePage.openRegisterPage();
        zipCodePage.inputZipCode(TestDataGenerator.getZipCode());
        zipCodePage.clickContinue();
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        boolean isRegisterDisplayed = signUpFormPage.isRegisterButtonDisplayed();
        Assert.assertEquals("s", "a");
//        Assert.assertTrue(isRegisterDisplayed, "Redirect to Sign Up failed");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.classicpageobject.SignUpFormPage;
import pages.classicpageobject.ZipCodePage;
import utilities.TestDataGenerator;

public class ZipCodeClassicalPomTest extends BaseTest {

    @Test
    public void zipCodeTest() {
        ZipCodePage zipCodePage = new ZipCodePage(driver);
        zipCodePage.openRegisterPage();
        zipCodePage.inputZipCode(TestDataGenerator.getZipCode());
        zipCodePage.clickContinue();
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        boolean isRegisterDisplayed = signUpFormPage.isRegisterButtonDisplayed();
        Assert.assertTrue(isRegisterDisplayed, "Redirect to Sign Up failed");
    }
}

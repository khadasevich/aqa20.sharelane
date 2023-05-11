package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.businesspages.ZipCodePage;
import pages.classicpageobject.SignUpFormPage;
import utilities.TestDataGenerator;

public class ZipCodeBusinessPomTest extends BaseTest {

    @Test
    public void zipCodeTest() {
        ZipCodePage zipCodePage = new ZipCodePage(driver);
        zipCodePage.proceedWithZipCode(TestDataGenerator.getZipCode());
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        boolean isRegisterDisplayed = signUpFormPage.isRegisterButtonDisplayed();
        Assert.assertTrue(isRegisterDisplayed, "Redirect to Sign Up failed");
    }
}

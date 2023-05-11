package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagefactorypages.SignUpFormPage;
import pages.pagefactorypages.ZipCodePage;
import utilities.TestDataGenerator;

public class ZipCodeFactoryTest extends BaseTest {

    @Test
    public void zipCodeTest() {
        ZipCodePage zipCodePage = new ZipCodePage(driver);
        zipCodePage.openZipCodePage();
        zipCodePage.inputZipCode(TestDataGenerator.getZipCode());
        zipCodePage.clickContinue();
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        boolean isRegisterDisplayed = signUpFormPage.isRegisterDisplayed();
        Assert.assertTrue(isRegisterDisplayed, "Redirect to Sign Up form failed");
    }
}

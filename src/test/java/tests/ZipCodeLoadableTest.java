package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loadablepage.SignUpFormPage;
import pages.loadablepage.ZipCodePage;
import utilities.TestDataGenerator;

public class ZipCodeLoadableTest extends BaseTest {

    @Test
    public void zipCodeTest() {
        ZipCodePage zipCodePage = new ZipCodePage(driver);
        zipCodePage.openRegisterPage();
        zipCodePage.isPageOpened();
        zipCodePage.inputZipCode(TestDataGenerator.getZipCode());
        zipCodePage.clickContinue();
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        boolean isPageOpened = signUpFormPage.isPageOpened();
        Assert.assertTrue(isPageOpened, "Sign Up form redirect failed");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loadablepage.SignUpFormPage;
import steps.ZipCodeSteps;
import utilities.TestDataGenerator;

public class ZipCodeWithStepsTest extends BaseTest {

    @Test
    public void zipcodeTest() {
        ZipCodeSteps.validateZipcode(driver, TestDataGenerator.getZipCode());
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        boolean isPageOpened = signUpFormPage.isPageOpened();
        Assert.assertTrue(isPageOpened, "Sign Up form redirect failed");
    }
}

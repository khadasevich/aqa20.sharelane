package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpages.ZipCodePage;
import utilities.TestDataGenerator;

public class RegistrationFluentTest extends BaseTest {

    @Test(description = "Register User in the system")
    public void registrationTest() {
        String password = TestDataGenerator.getPassword();
        ZipCodePage zipCodePage = new ZipCodePage(driver);
        boolean isSuccessDisplayed = zipCodePage
                .openRegisterPage()
                .inputZipCode(System.getProperty("zipCode"))
                .clickContinue()
                .fillInFirstName(TestDataGenerator.getFirstName())
                .fillInLastName(TestDataGenerator.getLastName())
                .fillInEmail(TestDataGenerator.getEmail())
                .fillInPassword(password)
                .fillInConfirmPassword(password)
                .clickRegister()
                .isSuccessMessageDisplayed();
        Assert.assertTrue(isSuccessDisplayed, "Register failed");
    }
}

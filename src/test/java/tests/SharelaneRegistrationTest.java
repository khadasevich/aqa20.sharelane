package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestDataGenerator;

import java.util.List;
import java.util.Set;

import static constants.PageUrls.*;

public class SharelaneRegistrationTest extends BaseTest {

    @Test
    public void fiveDigitsZipCodeTest() {
        // Open register page https://www.sharelane.com/cgi-bin/register.py
        driver.get(SHARELANE_REGISTER);
        // Input five digits to zip code field
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        String source = driver.getPageSource();
        String pageIdentifier = driver.getWindowHandle();
        Set<String> pageIds = driver.getWindowHandles();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click Continue button
        driver.findElement(By.cssSelector("[value='Continue']"));
        // Check Register button
        List<WebElement> registrationButtons = driver.findElements(By.cssSelector("[value='Register']"));
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed(), "Register button isn't displayed");
    }

    @Test
    public void loginSwagLabsTest() {
        driver.get(SAUCE_DEMO_LOGIN);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        String valueFromButton = driver.findElement(By.id("login-button")).getAttribute("value");
        driver.findElement(By.id("login-button")).submit();
    }

    @Test
    public void inputTest() {
        driver.get(INPUTS_PAGE);
        driver.findElement(By.cssSelector("[type]")).sendKeys(Keys.ARROW_UP);
        System.out.println("");
    }

    @Test
    public void checkBoxesTest() {
        driver.get(CHECKBOXES_PAGE);
        WebElement checkbox = driver.findElement(By.xpath("(//input)[1]"));
        checkbox.click();
        boolean isCheckBoxSelected = checkbox.isSelected();
        System.out.println("");
    }

    @Test
    public void positiveSingUpTest() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
        driver.findElement(By.name("first_name")).sendKeys(TestDataGenerator.getFirstName());
        driver.findElement(By.name("last_name")).sendKeys(TestDataGenerator.getLastName());
        driver.findElement(By.name("email")).sendKeys(TestDataGenerator.getEmail());
        String password = TestDataGenerator.getPassword();
        driver.findElement(By.name("password1")).sendKeys(password);
        driver.findElement(By.name("password2")).sendKeys(password);
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed(), "Register button is displayed");
    }
}

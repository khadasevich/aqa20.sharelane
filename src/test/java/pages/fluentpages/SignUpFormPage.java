package pages.fluentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpFormPage extends BasePage {
    private By REGISTER_BUTTON = By.cssSelector("[value='Register']");
    private By FIRST_NAME_INPUT = By.name("first_name");
    private By LAST_NAME_INPUT = By.name("last_name");
    private By EMAIL_INPUT = By.name("email");
    private By PASSWORD_INPUT = By.name("password1");
    private By CONFIRM_PASSWORD_INPUT = By.name("password2");

    public SignUpFormPage(WebDriver driver) {
        super(driver);
    }

    public SignUpFormPage fillInFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        return this;
    }

    public SignUpFormPage fillInLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        return this;
    }

    public SignUpFormPage fillInEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    public SignUpFormPage fillInPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public SignUpFormPage fillInConfirmPassword(String password) {
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public SuccessRegisterPage clickRegister() {
        driver.findElement(REGISTER_BUTTON).click();
        return new SuccessRegisterPage(driver);
    }

    public boolean isRegisterButtonDisplayed() {
        WebElement registerButton = driver.findElement(REGISTER_BUTTON);
        return registerButton.isDisplayed();
    }
}

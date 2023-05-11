package pages.loadablepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpFormPage extends BasePage {
    private By REGISTER_BUTTON = By.cssSelector("[value='Register']");

    public SignUpFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement registerButton = driver.findElement(REGISTER_BUTTON);
        return registerButton.isDisplayed();
    }
}

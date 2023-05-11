package pages.fluentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessRegisterPage extends BasePage {
    private By SUCCESS_MESSAGE = By.className("confirmation_message");

    public SuccessRegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        return successMessage.isDisplayed();
    }
}

package pages.pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpFormPage extends BasePage {
    @FindBy(css = "[value='Register']")
    private WebElement registerButton;

    public SignUpFormPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegisterDisplayed() {
        return registerButton.isDisplayed();
    }
}

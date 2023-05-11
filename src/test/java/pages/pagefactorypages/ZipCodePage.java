package pages.pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.PageUrls.SHARELANE_REGISTER;

public class ZipCodePage extends BasePage {
    @FindBy(id = "zip_code")
    private WebElement zipCodeInput;

    @FindBy(css = "[value='Continue']")
    private WebElement continueButton;

    public ZipCodePage(WebDriver driver) {
        super(driver);
    }

    public void openZipCodePage() {
        driver.get(SHARELANE_REGISTER);
    }

    public void inputZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}

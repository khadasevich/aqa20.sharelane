package pages.businesspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.PageUrls.SHARELANE_REGISTER;

public class ZipCodePage extends BasePage {
    private By ZIP_CODE_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value='Continue']");

    public ZipCodePage(WebDriver driver) {
        super(driver);
    }

    public void proceedWithZipCode(String zipCode) {
        driver.get(SHARELANE_REGISTER);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}

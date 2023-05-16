package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By CONFIRM_ALERT = By.cssSelector("[onclick='jsConfirm()']");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAlertsPage() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickButton() {
        driver.findElement(CONFIRM_ALERT).click();
    }

    public String acceptAlert() {
        clickButton();
        //для работы с алертами тоже используют switchTo() метод alert()
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public void dismissAlert() {
        clickButton();
        driver.switchTo().alert().dismiss();
    }

}

package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class AlertsPage {
    private WebDriver driver;
    private By CONFIRM_ALERT = By.cssSelector("[onclick='jsConfirm()']");
    private By FOOTER_LINK = By.linkText("Elemental Selenium");
    private By NEW_PAGE_HEADER = By.tagName("h1");

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

    public String switchToWindowAndGetText() {
        driver.findElement(FOOTER_LINK).click();
        //для переключения между табами необходимо получить уникальные идентификаторы страницы
        Set<String> windows = driver.getWindowHandles();
        //далее зная идентификатор страницы с помощью .window переключаемся
        driver.switchTo().window(windows.stream().toList().get(1));
        WebElement header = driver.findElement(NEW_PAGE_HEADER);
        //после работы с новой страницей необходимо возвращаться назад
        driver.switchTo().window(windows.stream().toList().get(0));
        return header.getText();
    }

}

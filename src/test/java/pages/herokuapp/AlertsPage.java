package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

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

    public void jsClickButton() {
        WebElement confirmAlert = driver.findElement(CONFIRM_ALERT);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", confirmAlert);
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

    public String switchToWindowAndWaitForText() {
        driver.findElement(FOOTER_LINK).click();
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window(windows.stream().toList().get(1));
        //При работе с explicit wait необходимо обнулить implicit wait
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_PAGE_HEADER));
        WebElement header = driver.findElement(NEW_PAGE_HEADER);
        //После работы с элементом возвращаем implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return header.getText();
    }

}

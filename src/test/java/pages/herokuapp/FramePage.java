package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramePage {
    private WebDriver driver;
    private By IFRAME_BODY = By.id("tinymce");
    private By IFRAME = By.xpath("//iframe[@title='Rich Text Area']");
    private By HEADER = By.tagName("h3");

    public FramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    public String getIframeBodyText() {
        //Прежде чем работать с элементами внутри фрейма необходимо в него переключиться
//        с помощью switchTo()
        WebElement iframe = driver.findElement(IFRAME);
        driver.switchTo().frame(iframe);
        WebElement iframeBody = driver.findElement(IFRAME_BODY);
        String text = iframeBody.getText();
        //После того как работа с фреймом закончена необходимо вернуть фокус на основной док
        driver.switchTo().parentFrame();
        return text;
    }

    public String getTextFromHeader() {
        WebElement header = driver.findElement(HEADER);
        return header.getText();
    }

}

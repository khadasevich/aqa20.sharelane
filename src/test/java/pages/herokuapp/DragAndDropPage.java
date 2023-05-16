package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private WebDriver driver;
    private By FRAME = By.className("demo-frame");
    private By DRAGGABLE_ELEMENT = By.id("draggable");
    private By DROPPABLE_ELEMENT = By.id("droppable");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://jqueryui.com/droppable/");
    }

    public void dragAndDrop() {
        WebElement frame = driver.findElement(FRAME);
        driver.switchTo().frame(frame);
        //Если необходим перехват действий мыши, двойные клики, зажатие и тд исп класс Actions
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(DRAGGABLE_ELEMENT);
        WebElement droppable = driver.findElement(DROPPABLE_ELEMENT);
        actions
                .dragAndDrop(draggable, droppable)
                //build собирает цепочку действий
                .build()
                //perform выполняет цепочку
                .perform();
    }
}

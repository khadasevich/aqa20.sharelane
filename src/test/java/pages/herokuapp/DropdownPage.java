package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;
    private By DROPDOWN_LIST = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    public String selectOptionOne() {
        WebElement dropdownList = driver.findElement(DROPDOWN_LIST);
        //для работы с выпадающими списками используется класс Select
        Select select = new Select(dropdownList);
        select.selectByValue("1");
        return select.getFirstSelectedOption().getText();
    }
}

package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {
    private WebDriver driver;
    private By UPLOAD_INPUT = By.id("file-upload");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    public void uploadPhoto() {
        WebElement uploadInput = driver.findElement(UPLOAD_INPUT);
        //добавление картинки происходит с помощью sendKeys
        uploadInput.sendKeys(System.getProperty("user.dir").concat("/src/test/resources/photos/Screenshot_2.png"));

    }
}

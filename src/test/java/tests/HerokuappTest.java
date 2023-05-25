package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.herokuapp.*;
import utilities.Retry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Epic("Herokuapp")
@Feature("Selenium Training")
@Story("Selenium Tests")
@Tags(@Tag("herokuapp"))
public class HerokuappTest extends BaseTest {

    @Test(priority = 1, invocationCount = 10, retryAnalyzer = Retry.class, enabled = false)
    public void iframeBodyTest() {
        FramePage framePage = new FramePage(driver);
        framePage.openPage();
        String textInsideOfFrame = framePage.getIframeBodyText();
        String textInsideOfHeader = framePage.getTextFromHeader();
    }

    @Test(priority = 2)
    public void alertTest() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlertsPage();
        String text = alertsPage.acceptAlert();
        alertsPage.dismissAlert();
        Assert.assertEquals(text, "I am a JS Confir");
    }

    @Test(enabled = false)
    public void switchToNewWindow() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlertsPage();
        String text = alertsPage.switchToWindowAndGetText();
    }

    @Test(priority = 3)
    public void switchToNewWindowAndWaitTest() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlertsPage();
        String text = alertsPage.switchToWindowAndWaitForText();
    }

    @Test(description = "Upload photo test")
    public void uploadPhotoTest() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.openPage();
        fileUploadPage.uploadPhoto();
    }

    @Test
    public void selectTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.openPage();
        String option = dropdownPage.selectOptionOne();
    }

    @Test
    public void dragAndDropTest() throws IOException {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.openPage();
        dragAndDropPage.dragAndDrop();
        //сделать скриншот
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] screenshotInBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot.png"), screenshotInBytes);
    }

    @Test
    public void jsClickTest() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlertsPage();
        alertsPage.jsClickButton();
    }
}

package tests;

import org.testng.annotations.Test;
import pages.herokuapp.*;

public class HerokuappTest extends BaseTest {

    @Test
    public void iframeBodyTest() {
        FramePage framePage = new FramePage(driver);
        framePage.openPage();
        String textInsideOfFrame = framePage.getIframeBodyText();
        String textInsideOfHeader = framePage.getTextFromHeader();
    }

    @Test
    public void alertTest() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlertsPage();
        String text = alertsPage.acceptAlert();
        alertsPage.dismissAlert();
    }

    @Test
    public void switchToNewWindow() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlertsPage();
        String text = alertsPage.switchToWindowAndGetText();
    }

    @Test
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
    public void dragAndDropTest(){
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.openPage();
        dragAndDropPage.dragAndDrop();
    }
}

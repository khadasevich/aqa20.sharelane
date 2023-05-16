package tests;

import org.testng.annotations.Test;
import pages.herokuapp.FramePage;

public class HerokuappTest extends BaseTest {

    @Test
    public void iframeBodyTest() {
        FramePage framePage = new FramePage(driver);
        framePage.openPage();
        String textInsideOfFrame = framePage.getIframeBodyText();
        String textInsideOfHeader = framePage.getTextFromHeader();
    }
}

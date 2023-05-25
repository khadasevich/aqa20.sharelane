package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.saucedemo.LoginPage;

@Epic("User management")
@Feature("Login")
@Story("Validation")
public class SauceDemoLoginTest extends BaseTest {

    @Test(dataProvider = "testData")
    //В аннотации указывается имя дата порвайдера,
    // а в качестве параметров тестового метода указываются, что будет передавать датапровайдер
    public void invalidLoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error wasn't shown");
    }

    @DataProvider(name = "testData")
    public Object[][] inputForTask() {
        //Метод необходим для подготовки многомерного массива данных для теста
        return new Object[][]{
                {"", ""},
                {"", "secret_sauce"},
                {"standard_user", ""},
                {"standard_use", "secret_sauc"},
        };
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.saucedemo.LoginPage;

public class BaseTestWithThreadLocal {
    //Класс нужен для демонстрации того как работать с тред локал
    //!!не тянуть в тестовые фреймворки
    private static WebDriver driver;
    private ThreadLocal<WebDriver> threadLocal;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        threadLocal = new ThreadLocal<>();
        threadLocal.set(driver);
        LoginPage loginPage = new LoginPage(threadLocal.get());
    }

    @AfterMethod
    public void tearDown() {
        threadLocal.get().quit();
    }
}

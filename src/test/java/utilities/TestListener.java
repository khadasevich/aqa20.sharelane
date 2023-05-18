package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">>>>>>>>>>>> Test " + result.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " Test Passed <<<<<<<<<");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " Test Failed <<<<<<<<<");
        //Из контекста тестов получаем инстанс класса из которого происходит запуск теста
        Object currentClass = result.getInstance();
        //Приводим (cast) object к классу базового теста и получаем доступ к методам класса
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        Screenshoter.takeScreenShot(driver);
    }
}

package seleniumTasks.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTasks.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise1 extends BaseTest{

    @Test
    public void loginPositive() {

        login(username);
        //List<WebElement> errorBox = driver.findElements(By.className("validation-summary-errors"));
        //Assert.assertTrue(errorBox.size() == 0);


    }
}

package seleniumTasks.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTasks.BaseTest;

public class Exercise2 extends BaseTest {

    @Test
    public void loginPositive() {

        login(username, myPwd);
        WebElement errorBox = driver.findElement(By.id("mailbox:error"));
        Assert.assertFalse(errorBox.getText().contains("Неверное имя или пароль"));
    }
}

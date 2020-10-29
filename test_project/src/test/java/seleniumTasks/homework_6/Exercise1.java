package seleniumTasks.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumTasks.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Exercise1 extends BaseTest {

    @DataProvider
    public Object[][] emailSubject() {
        String subject = "Новое письмо " + java.util.UUID.randomUUID().toString();
        return new Object[][]{
                {subject}
        };
    }


    @Test (dataProvider = "emailSubject")
    public void loginPositive(String emailSubject) {

        login(username, myPwd);
        WebElement errorBox = driver.findElement(By.id("mailbox:error"));
        Assert.assertFalse(errorBox.getText().contains("Неверное имя или пароль"));


        WebElement newEmail = wait.until(visibilityOfElementLocated(By.partialLinkText("Написать письмо")));
        newEmail.click();

        WebElement toWhom = driver.findElement(By.cssSelector("div.contacts--1ofjA input.container--H9L5q"));
        toWhom.clear();
        toWhom.sendKeys("dmatveeva@gmail.com");

        WebElement subject = driver.findElement(By.cssSelector("div.subject__wrapper--2mk6m input.container--H9L5q"));
        subject.clear();

        subject.sendKeys(emailSubject);

        WebElement textField = driver.findElement(By.cssSelector("div.cke_editable > div:first-child"));
        textField.click();
        textField.clear();
        textField.sendKeys("Тест#1");

        WebElement saveButton = driver.findElement(By.cssSelector("span.button2[title='Сохранить']"));
        saveButton.click();

        WebElement closeComposeWindow = driver.findElement(By.cssSelector("button.container--2lPGK[title='Закрыть']"));
        closeComposeWindow.click();

        WebElement draftsFolder = driver.findElement(By.partialLinkText("Черновики"));
        draftsFolder.click();

        WebElement lastDraftSubject = driver.findElement(By.partialLinkText(emailSubject));
        lastDraftSubject.click();

        
//        WebElement lastDraftSubject = driver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div/a[2]/div[4]/div/div[3]/span[1]/span"));
//        Assert.assertTrue(lastDraftToWhom.getText().contains("dmatveeva@gmail.com") && lastDraftSubject.getText().contains("Тестовое письмо"));
    }

//*[@id="app-canvas"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div/a[2]/div[4]/div/div[1]/span
}



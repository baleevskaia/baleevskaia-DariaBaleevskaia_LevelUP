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

public class Exercise1_Test extends BaseTest {

    @DataProvider
    public Object[][] email() {
        String emailSubject = "Новое письмо " + java.util.UUID.randomUUID().toString();

        return new Object[][]{
                {emailSubject}
        };
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    @Test(dataProvider = "email")
    public void draftSent(String emailSubject) {

        login(username, myPwd);
        WebElement errorBox = driver.findElement(By.id("mailbox:error"));
        Assert.assertFalse(errorBox.getText().contains("Неверное имя или пароль"));


        WebElement newEmail = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Написать письмо")));
        newEmail.click();

        WebElement toWhom = wait.until(visibilityOfElementLocated(By.cssSelector("div.contacts--1ofjA input.container--H9L5q")));
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

        WebElement draftsFolder = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Черновики")));
        draftsFolder.click();

        WebElement lastDraftSubject = driver.findElement(By.partialLinkText(emailSubject));
        lastDraftSubject.click();
        WebElement toWhomRes = driver.findElement(By.cssSelector("span.text--1tHKB"));
        WebElement textFieldRes = driver.findElement(By.cssSelector("div.cke_editable > div:first-child > div:first-child > div:first-child> div:first-child> div:first-child"));
        //Verify контент, адресата и тему письма
        Assert.assertTrue(lastDraftSubject.getText().contains(emailSubject) && toWhomRes.getText().contains("dmatveeva@gmail.com") && textFieldRes.getText().contentEquals("Тест#1"));

        WebElement sendButton = driver.findElement(By.cssSelector("span.button2[title='Отправить']"));
        sendButton.click();

        WebElement closeSend = driver.findElement(By.cssSelector("span.button2_has-ico[title='Закрыть']"));
        closeSend.click();
        wait.until(ExpectedConditions.stalenessOf(lastDraftSubject));

        //Verify, что письмо исчезло из черновиков
        Assert.assertFalse(isElementPresent(By.partialLinkText(emailSubject)));

        WebElement sentFolder = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Отправленные")));
        sentFolder.click();
        //Verify, что письмо появилось в папке отправленные
        Assert.assertTrue(isElementPresent(By.partialLinkText(emailSubject)));

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("выход")));
        logoutButton.click();
        
    }

}



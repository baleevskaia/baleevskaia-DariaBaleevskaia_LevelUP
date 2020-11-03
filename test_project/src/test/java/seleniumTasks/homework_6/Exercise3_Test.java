package seleniumTasks.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumTasks.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Exercise3_Test extends BaseTest {
    @DataProvider
    public Object[][] email() {
        String emailSubject = "Письмо№3 " + java.util.UUID.randomUUID().toString();
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
    public void deleteInputMail(String emailSubject) {

        login(username, myPwd);
        WebElement errorBox = driver.findElement(By.id("mailbox:error"));
        Assert.assertFalse(errorBox.getText().contains("Неверное имя или пароль"));

        WebElement newEmail = wait.until(visibilityOfElementLocated(By.partialLinkText("Написать письмо")));
        newEmail.click();

        WebElement toWhom = wait.until(visibilityOfElementLocated(By.cssSelector("div.contacts--1ofjA input.container--H9L5q")));
        toWhom.clear();
        toWhom.sendKeys("selena.khromova@list.ru");

        WebElement subject = driver.findElement(By.cssSelector("div.subject__wrapper--2mk6m input.container--H9L5q"));
        subject.clear();

        subject.sendKeys(emailSubject);

        WebElement textField = driver.findElement(By.cssSelector("div.cke_editable > div:first-child"));
        textField.click();
        textField.clear();
        textField.sendKeys("Test#3");

        WebElement sendButton = driver.findElement(By.cssSelector("span.button2[title='Отправить']"));
        sendButton.click();

        WebElement closeSendingWindow = driver.findElement(By.cssSelector("span.button2[title='Закрыть']"));
        closeSendingWindow.click();

        WebElement inputFolder = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Входящие")));
        inputFolder.click();
        Assert.assertTrue(isElementPresent(By.partialLinkText(emailSubject)));

        //Verify тему письма (должно совпадать с пунктом 3)
        WebElement lastTest3Subject =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(emailSubject)));
        Assert.assertTrue(lastTest3Subject.getText().contains(emailSubject));
        lastTest3Subject.click();

        WebElement lastTest3SubjectUnfold =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(emailSubject)));
        lastTest3SubjectUnfold.click();

        //Verify контент, адресата
        WebElement toWhomRes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.letter__recipients>span.letter-contact")));
        WebElement textFieldRes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.letter-body__body-content div[class^='cl']>div:first-child")));
        Assert.assertTrue(toWhomRes.getAttribute("title").contains("selena.khromova@list.ru") && textFieldRes.getText().contains("Test#3"));

        WebElement deleteBtn = driver.findElement(By.cssSelector("span.button2_delete[title='Удалить']"));
        deleteBtn.click();

        WebElement binFolder = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Корзина")));
        binFolder.click();

        //Verify что письмо появилось в папке Корзина
        Assert.assertTrue(isElementPresent(By.partialLinkText(emailSubject)));




    }
}

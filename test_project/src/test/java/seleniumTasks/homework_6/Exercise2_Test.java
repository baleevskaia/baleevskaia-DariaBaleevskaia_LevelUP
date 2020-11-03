package seleniumTasks.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumTasks.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Exercise2_Test extends BaseTest {

    @DataProvider
    public Object[][] email() {
        String emailSubject = "Тест " + java.util.UUID.randomUUID().toString();
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
    public void testMailRule (String emailSubject) {

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
        textField.sendKeys("Test#2");

        WebElement sendButton = driver.findElement(By.cssSelector("span.button2[title='Отправить']"));
        sendButton.click();

        WebElement closeSendingWindow = driver.findElement(By.cssSelector("span.button2[title='Закрыть']"));
        closeSendingWindow.click();

        //<span class="button2 button2_has-ico button2_close button2_pure button2_clean button2_short button2_hover-support" title="Закрыть"><span class="button2__wrapper" tabindex="1000"><span class="button2__ico"><svg class="ico ico_16-close ico_size_s" width="16" height="16" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M7.983 6.455l4.34-4.34a1.105 1.105 0 011.562 1.562l-4.34 4.34 4.34 4.34a1.08 1.08 0 11-1.528 1.528l-4.34-4.34-4.34 4.34a1.105 1.105 0 01-1.562-1.562l4.34-4.34-4.34-4.34a1.08 1.08 0 111.528-1.528l4.34 4.34z"></path></svg></span></span></span>


        //Verify, что письмо появилось в папке отправленные
        WebElement sentFolder = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Отправленные")));
        sentFolder.click();
        Assert.assertTrue(isElementPresent(By.partialLinkText(emailSubject)));

        //Verify, что письмо появилось в папке «Тест»
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title^='Тест']>div span.badge__text")));
        WebElement testFolder = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Тест")));
        testFolder.click();
        Assert.assertTrue(isElementPresent(By.partialLinkText(emailSubject)));

        //Verify тему письма (должно совпадать с пунктом 3)
        WebElement lastTestSubject =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(emailSubject)));
        Assert.assertTrue(lastTestSubject.getText().contains(emailSubject));
        lastTestSubject.click();

        //Verify контент, адресата

        WebElement toWhomRes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.letter__recipients>span.letter-contact")));
        WebElement textFieldRes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.letter-body__body-content div[class^='cl']>div:first-child")));
        Assert.assertTrue(toWhomRes.getAttribute("title").contains("selena.khromova@list.ru") && textFieldRes.getText().contains("Test#2"));

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("выход")));
        logoutButton.click();
    }
}

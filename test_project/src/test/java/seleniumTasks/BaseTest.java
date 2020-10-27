package seleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected String username = "selena.khromova";
    protected String myPwd = "SeleniumTool";

    @BeforeMethod
    public void initData() {
        System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("chromedriver.exe").getFile());

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
    }

    protected void login(String userName) {
        WebElement name = driver.findElement(By.id("mailbox:mailHeaderSecondStepBack"));
        name.clear();
        name.sendKeys(userName);

       // Select selectDomain = new Select(driver.findElement(By.id("mailbox:domain")));
       // selectDomain.selectByVisibleText("@list.ru");



      /*  WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys(pwd);

        WebElement logonBtn = driver.findElement(By.id("logonButton"));
        logonBtn.click(); */

    }


    @AfterMethod
    public void stop() {
        driver.quit();
    }


}


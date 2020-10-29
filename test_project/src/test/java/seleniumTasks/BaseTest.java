package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String username = "selena.khromova";
    protected String myPwd = "SeleniumTool";

    @BeforeClass
    public void initData() {
        // System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("chromedriver.exe").getFile());
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "start-maximized");

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
    }

    protected void login(String userName, String myPwd) {
        WebElement name = driver.findElement(By.id("mailbox:login-input"));
        name.clear();
        name.sendKeys(userName);

        Select selectDomain = new Select(driver.findElement(By.id("mailbox:domain")));
        selectDomain.selectByVisibleText("@list.ru");


        WebElement password = driver.findElement(By.id("mailbox:submit-button"));
        password.click();
        WebElement pwdInput = driver.findElement(By.id("mailbox:password-input"));
        pwdInput.clear();
        pwdInput.sendKeys(myPwd);

        WebElement logonBtn = driver.findElement(By.id("mailbox:submit-button"));
        logonBtn.click();

    }


    @AfterClass
    public void stop() {
        driver.quit();
    }


}


package homework_5.calculatorTestSet;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.levelup.qa.at.calculator.Calculator;

public class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void setUpSuite(){
        System.out.println("Set up Test Suite");
    }

    @BeforeMethod
    public void setUpTestMethod() {
        System.out.println("Set up Test Method");
        calculator = new Calculator();
    }


    @AfterMethod
    public void tearDownTestMethod() {
        System.out.println("Tear down Test Method");
        calculator = null;
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("Tear down Test Suite");
    }
}

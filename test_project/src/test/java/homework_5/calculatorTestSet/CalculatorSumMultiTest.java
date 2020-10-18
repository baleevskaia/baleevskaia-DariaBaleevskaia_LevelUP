package homework_5.calculatorTestSet;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.levelup.qa.at.calculator.Calculator;

public class CalculatorSumMultiTest {

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

    @Test
    public void calculatorSumTest1() {
        System.out.println("Calculator Sum Test Run...");
        double actual = calculator.sum(2.0, 2.0);
        Assert.assertEquals(actual, 4.0, 0.00000001);
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

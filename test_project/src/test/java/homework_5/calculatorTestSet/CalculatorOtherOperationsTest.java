package homework_5.calculatorTestSet;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorOtherOperationsTest extends BaseCalculatorTest {

    @DataProvider
    public Object[][] isNegativeDataProvider() {
        return new Object[][]{
                {1000000, false},
                {Long.MIN_VALUE, true},
                {0, false}
        };
    }

    @DataProvider
    public Object[][] isPositiveDataProvider() {
        return new Object[][]{
                {1000000, true},
                {Long.MIN_VALUE, false},
                {0, false}
        };
    }

    @DataProvider
    public Object[][]powDataProvider() {
        return new Object[][]{
                {2.0, 4.0, 16.0},
                {5.0, 1.0, 5},
                {4.0, 0.5, 2.0}
        };
    }

    @DataProvider
    public Object[][]sqrtDataProvider() {
        return new Object[][]{
                {16.0, 4.0},
                {1.0, 1.0},
                {169.0, 13.0}
        };
    }

    @Test(dataProvider = "isNegativeDataProvider")
    public void calculatorIsNegativeTest(long a, boolean expected) {
        System.out.println("Calculator IsNegative Test Run...");
        boolean actual = calculator.isNegative(a);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "isPositiveDataProvider")
    public void calculatorIsPositiveTest(long a, boolean expected) {
        System.out.println("Calculator IsPositive Test Run...");
        boolean actual = calculator.isPositive(a);
        Assert.assertEquals(actual, expected);
    }

    @Test (dataProvider = "powDataProvider")
    public void calculatorPowTest(double a, double b, double expected) {
        System.out.println("Calculator PowerTest Run...");
        double actual = calculator.pow(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test (dataProvider = "sqrtDataProvider")
    public void calculatorSqrtTest(double a, double expected) {
        System.out.println("Calculator SqrtTest Run...");
        double actual = calculator.sqrt(a);
        Assert.assertEquals(actual, expected, 0.00000001);
    }
}

package homework_5.calculatorTestSet;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubDivTest extends BaseCalculatorTest {
    @DataProvider
    public Object[][] subDoubleDataProvider() {
        return new Object[][]{
                {5.0, 5.0, 0.0},
                {-1.5, -2.0, 0.5},
                {0.0, 110.0, -110.0}
        };
    }

    @DataProvider
    public Object[][] subLongDataProvider() {
        return new Object[][]{
                {1000000, 1000000, 0},
                {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                {-1000000, 1000000, -2000000}
        };
    }

    @DataProvider
    public Object[][] divDoubleDataProvider() {
        return new Object[][]{
                {5.0, 5.0, 1.0},
                {-1.5, -2.0, 0.75},
                {0.0, 110.0, 0}
        };
    }

    @DataProvider
    public Object[][] divLongDataProvider() {
        return new Object[][]{
                {1000000, 1000000, 1},
                {Long.MAX_VALUE, 1, Long.MAX_VALUE},
                {-1000000, 1000000, -1}
        };
    }

    @Test(dataProvider = "subDoubleDataProvider")
    public void calculatorSubDoubleTest(double a, double b, double expected) {
        System.out.println("Calculator SubDouble Test Run...");
        double actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test(dataProvider = "subLongDataProvider")
    public void calculatorSubLongTest(long a, long b, long expected) {
        System.out.println("Calculator SubLong Test Run...");
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test(dataProvider = "divDoubleDataProvider")
    public void calculatorDivDoubleTest(double a, double b, double expected) {
        System.out.println("Calculator DivDouble Test Run...");
        double actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test(dataProvider = "divLongDataProvider")
    public void calculatorDivLongTest(long a, long b, long expected) {
        System.out.println("Calculator DivLong Test Run...");
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

}

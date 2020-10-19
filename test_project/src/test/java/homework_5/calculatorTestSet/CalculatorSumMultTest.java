package homework_5.calculatorTestSet;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.levelup.qa.at.calculator.Calculator;

public class CalculatorSumMultTest extends BaseCalculatorTest {

    @DataProvider
    public Object[][] sumDoubleDataProvider() {
        return new Object[][]{
                {5.0, 5.0, 10.0},
                {-1.5, -2.0, -3.5},
                {0.0, 110.0, 110}
        };
    }

    @DataProvider
    public Object[][] sumLongDataProvider() {
        return new Object[][]{
                {1000000, 1000000, 2000000},
                {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                {-1000000, 1000000, 0}
        };
    }

    @DataProvider
    public Object[][] multDoubleDataProvider() {
        return new Object[][]{
                {5.0, 5.0, 25.0},
                {-1.50, 1.50, -2.25},
                {0.0, 110.0, 0}
        };
    }

    @DataProvider
    public Object[][] multLongDataProvider() {
        return new Object[][]{
                {1000000, 2, 2000000},
                {Long.MAX_VALUE, 0, 0},
                {3333333, -1, -3333333}
        };
    }


    @Test (dataProvider = "sumDoubleDataProvider")
    public void calculatorSumDoubleTest(double a, double b, double expected) {
        System.out.println("Calculator SumDouble Test Run...");
        double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test (dataProvider = "sumLongDataProvider")
    public void calculatorSumLongTest(long a, long b, long expected) {
        System.out.println("Calculator SumLong Test Run...");
        double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test (dataProvider = "multDoubleDataProvider")
    public void calculatorMultDoubleTest(double a, double b, double expected) {
        System.out.println("Calculator MultDouble Test Run...");
        double actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test (dataProvider = "multLongDataProvider")
    public void calculatorMultLongTest(double a, double b, double expected) {
        System.out.println("Calculator MultLong Test Run...");
        double actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

}

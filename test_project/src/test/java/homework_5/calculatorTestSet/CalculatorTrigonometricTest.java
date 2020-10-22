package homework_5.calculatorTestSet;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTrigonometricTest extends BaseCalculatorTest {

    @DataProvider
    public Object[][] cosDoubleDataProvider() {
        return new Object[][]{
                {0.0, 1.0},
                {Math.PI, -1.0},
                {Math.PI/2, 0.0}
        };
    }

    @DataProvider
    public Object[][] sinDoubleDataProvider() {
        return new Object[][]{
                {0.0, 0.0},
                {Math.PI, 0.0},
                {Math.PI/2, 1.0}
        };
    }

    @DataProvider
    public Object[][] tgDoubleDataProvider() {
        return new Object[][]{
                {0.0, 0.0},
                {Math.PI, 0.0},
                {Math.PI/4, 1.0}
        };
    }

    @DataProvider
    public Object[][] ctgDoubleDataProvider() {
        return new Object[][]{
                {0.0, 0.0},
                {Math.PI, 0.0},
                {Math.PI/4, 1.0}
        };
    }


    @Test (dataProvider = "cosDoubleDataProvider")
    public void calculatorCosDoubleTest(double a, double expected) {
        System.out.println("Calculator Cos Test Run...");
        double actual = calculator.cos(a);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test (dataProvider = "sinDoubleDataProvider")
    public void calculatorSinDoubleTest(double a, double expected) {
        System.out.println("Calculator Sin Test Run...");
        double actual = calculator.sin(a);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test (dataProvider = "tgDoubleDataProvider")
    public void calculatorTgDoubleTest(double a, double expected) {
        System.out.println("Calculator Tg Test Run...");
        double actual = calculator.tg(a);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test (dataProvider = "tgDoubleDataProvider")
    public void calculatorCtgDoubleTest(double a, double expected) {
        System.out.println("Calculator Ctg Test Run...");
        double actual = calculator.ctg(a);
        Assert.assertEquals(actual, expected, 0.00000001);
    }



}

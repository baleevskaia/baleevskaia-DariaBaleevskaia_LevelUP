package homework_5.calculatorTestSet;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class CalculatorSumTest {

    @Test
    public void calculatorSumTest1() {
        System.out.println("Calculator Sum Test Run...");
        Calculator calculator = new Calculator();
        double actual = calculator.sum(2.0, 2.0);
        Assert.assertEquals(actual, 4.0, 0.00000001);
    }


}

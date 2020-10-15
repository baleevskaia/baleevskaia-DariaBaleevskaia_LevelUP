package homework_2.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public void start() throws IOException {
        MathOperations operation = readOperation();
        switch (operation) {
            case addition:
                double a1 = readDouble("Input the first number: ");
                double b1 = readDouble("Input the second number: ");
                System.out.println(add(a1, b1));
                break;
            case subtraction:
                double a2 = readDouble("Input the first number: ");
                double b2 = readDouble("Input the second number: ");
                System.out.println(sub(a2, b2));
                break;
            case multiplication:
                double a3 = readDouble("Input the first number: ");
                double b3 = readDouble("Input the second number: ");
                System.out.println(mult(a3, b3));
                break;
            case division:
                double a4 = readDouble("Input the first number: ");
                double b4 = readDouble("Input the second number: ");
                System.out.println(div(a4, b4));
                break;
            case power:
                int a5 = readInt("Input the value: ");
                int b5 = readInt("Input the power: ");
                System.out.println(power(a5, b5));
                break;
            case factorial:
                int a6 = readInt("Input the value: ");
                System.out.println(factorial(a6));
                break;
            case fibonacci:
                int a7 = readInt("Input the value: ");
                System.out.println(fibonacci(a7));
                break;
        }
    }

    private double readDouble(String helpText) throws IOException {
        System.out.println(helpText);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        return Double.parseDouble(num);
    }

    private int readInt(String helpText) throws IOException {
        System.out.println(helpText);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        return Integer.parseInt(num);
    }

    private MathOperations readOperation() throws IOException {
        System.out.println("Input math operation: 1 - addition, 2 - subtraction, 3 - multiplication, 4 - division, 5 - power, 6 - factorial, 7 - fibonacci.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String operation = reader.readLine();
        int operationNum = Integer.parseInt(operation);
        switch (operationNum) {
            case 1:
                return MathOperations.addition;
            case 2:
                return MathOperations.subtraction;
            case 3:
                return MathOperations.multiplication;
            case 4:
                return MathOperations.division;
            case 5:
                return MathOperations.power;
            case 6:
                return MathOperations.factorial;
            case 7:
                return MathOperations.fibonacci;
            default:
                throw new IOException("Wrong operation!");
        }
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double sub(double a, double b) {
        return a - b;
    }

    private double mult(double a, double b) {
        return a * b;
    }

    private double div(double a, double b) throws IOException {
        if (b == 0) {
            throw new IOException("Division by 0 is prohibited!");
        }
        return a / b;
    }

    private long power(int a, int b) throws IOException {
        if (b <= 1) {
            throw new IOException("Power should be greater than 1");
        }
        long res = 1;
        for (int i = 0; i < b; i++) {
            res = res * a;
        }
        return res;
    }

    private static long factorial(int a) throws IOException {
        if (a <= 0) {
            throw new IOException("Value should be positive!");
        }
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        return result;
    }

    private int fibonacci(int a) throws IOException {
        if (a <= 0) {
            throw new IOException("Value should be positive!");
        }
        if (a <= 2) {
            return 1;
        }
        int previous = 1;
        int current = 1;

        for (int i = 2; i < a; i++) {
            int temp = previous;
            previous = current;
            current = previous + temp;
        }

        return current;
    }
}

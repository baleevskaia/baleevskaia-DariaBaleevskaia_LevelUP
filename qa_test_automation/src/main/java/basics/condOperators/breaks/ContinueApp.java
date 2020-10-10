package basics.condOperators.breaks;

public class ContinueApp {
    public static void main(String[] args) {

        int sum = 0;
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            if (i % 2 != 0) {
                continue;
            }
             sum += i;
        }
        System.out.println("sum: " + sum);

    }
}

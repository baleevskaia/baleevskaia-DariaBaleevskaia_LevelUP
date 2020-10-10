package basics.condOperators.breaks;

public class BreakApp {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 8) {
                System.out.println("Smth went wrong!");
                break;
            }

        }

        System.out.println("============================");


        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 100};
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            if (a[i] == 50) {
                System.out.println("Win");
                res = a[i];
                break;
            }
        }
        System.out.println("res: " + res);

    }
}

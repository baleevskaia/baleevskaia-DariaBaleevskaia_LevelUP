package basics.condOperators.breaks;

public class ReturnApp {
    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 100};
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            if (a[i] == 50) {
                System.out.println("Win");
                res = a[i];
                return;
            }
        }
        System.out.println("res: " + res);
    }
}

public class Lab1 {
    public static void main(String[] args) {
        // C2 = 0; O1 = +; C = 1; O2 = +; int
        int id = 1108;
        int C = id % 3;
        int n = 5;
        int m = 5;
        int a = 1;
        int b = 1;

        if (n < a || m < b || a < 0) {
            System.err.println("Invalid parameter values");
            return;
        }

        double resultSum = 0.0;

        for (int i = a; i <= n; i++) {
            double innerSum = 0.0;

            for (int j = b; j <= m; j++) {
                double numerator = i + j;
                double denominator = i + C;
                innerSum += numerator / denominator;
            }
            resultSum += innerSum;
        }

        System.out.println("S = " + resultSum);
    }
}

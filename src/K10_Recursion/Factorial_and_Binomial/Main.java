package K10_Recursion.Factorial_Binomial;

public class Main {
    public static void main(String[] args) {
        int n = 13, k = 2;
        int b1 = binom(n, k);
        int b2 = binomRecursive(n, k);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        /* int f = factorial(n);
        System.out.printf("factorial(%d) = %d\n", n, f);
        int r = factorialRecursive(n);
        System.out.printf("factorialRecursive(%d) = %d\n", n, r);*/

    }

    static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // x! = x * (x-1)!
    static int factorialRecursive(int x) {
        System.out.println("factorialRecursive called with parameter " + x);
        if (x == 0) {
            // Basisfall
            return 1;
        } else {
            // rekursiver Fall
            int temp = factorialRecursive(x - 1);
            System.out.println("factorialRecursive for par. " + (x-1) + " returned " + temp);
            int temp2 =  x * temp;
            System.out.println("factorialRecursive returns " + temp2);
            return temp2;
        }
    }

    static int binom(int n, int k) {
        int t1 = factorialRecursive(n);
        int t2 = factorialRecursive(n-k);
        int t3 = factorialRecursive(k);
        System.out.printf("%d %d %d\n", t1, t2, t3);
        return t1 / (t2*t3);
    }

    static int binomRecursive(int n, int k) {
        if (n == k || k == 0) {
            // Basisfall
            return 1;
        } else {
            // rekursiver Fall
            return binomRecursive(n-1, k-1) + binomRecursive(n-1, k);
        }
    }
}

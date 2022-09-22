package ETC;

import java.util.Scanner;

public class q1629 {

    static long c;

    static long myPow(long x, int y) {
        if (y == 0)
            return 1;
        long tmp = myPow(x, y / 2);
        if (y % 2 == 0)
            return tmp * tmp % c;
        else
            return tmp * tmp % c * x % c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();
        c = sc.nextInt();
        sc.close();

        System.out.print(myPow(a, b));

    }
}

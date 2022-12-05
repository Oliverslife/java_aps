package ETC;

import java.util.Scanner;

public class q11401 {

    static int mod = 1000000007;

    static long myPow(long x, int y) {
        if (y == 0)
            return 1;
        long tmp = myPow(x, y / 2);
        if (y % 2 == 0)
            return tmp * tmp % mod;
        else
            return tmp * tmp % mod * x % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        long[] fac;
        fac = new long[n+1];
        fac[0] = 1;

        for(int i=1; i<=n; i++)
            fac[i] = fac[i-1] * i % mod;

        long bottom = fac[k] * fac[n-k] % mod;
        long rebottom = myPow(bottom, mod - 2);
        long top = fac[n];

        System.out.print(top * rebottom % mod);
    }
}

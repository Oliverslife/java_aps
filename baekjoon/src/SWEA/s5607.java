package SWEA;

import java.util.Scanner;

public class s5607 {
    static long myPow(long n, int r) {
        if(r == 0)
            return 1;
        long tmp = myPow(n, r / 2);
        if(r % 2 == 0)
            return tmp * tmp % mod;
        else
            return tmp * tmp % mod * n % mod;
    }

    static int mod = 1234567891;;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, r;
        long[] fac;

        for(int tc=1; tc<=t; tc++) {

            n = sc.nextInt();
            r = sc.nextInt();
            fac = new long[n+1];
            fac[0] = 1;

            for(int i=1; i<=n; i++)
                fac[i] = fac[i-1] * i % mod;

            long b = fac[r] * fac[n-r] % mod;
            long rb = myPow(b, mod - 2);
            long ans = fac[n] * rb % mod;

            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }
}

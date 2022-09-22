package ETC;

import java.util.Scanner;

public class q18291 {

    static int mod = 1000000007;
    static long myPow(int n) {
        if (n == 0)
            return 1;
        long tmp = myPow(n / 2);
        if (n % 2 == 0)
            return tmp * tmp % mod;
        else
            return tmp * tmp % mod * 2 % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;          //n번까지 가는 경우 > 2의 n-2제곱
        long ans;
        while(t-- > 0) {

            n = sc.nextInt();
            ans = 0;
            if(n <= 2)
                ans = 1;
            else
                ans = myPow(n-2);

            System.out.println(ans);
        }
        sc.close();
    }
}

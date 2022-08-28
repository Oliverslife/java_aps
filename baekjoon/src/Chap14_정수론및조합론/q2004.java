package Chap14_정수론및조합론;

import java.util.Scanner;

public class q2004 {

    static long c5(long n) {
        int cnt = 0;
        while(n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    static long c2(long n) {
        int cnt = 0;
        while(n >= 2) {
            cnt += n / 2;
            n /= 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();

        long cnt5 = c5(a) - c5(a-b) - c5(b);
        long cnt2 = c2(a) - c2(a-b) - c2(b);

        System.out.print(Math.min(cnt5, cnt2));
    }
}

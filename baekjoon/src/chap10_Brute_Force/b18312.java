package chap10_Brute_Force;

import java.util.Scanner;

public class b18312 {

    public static void main(String[] args) {

        int N, K, h, m, s, ans = 0;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        sc.close();

        for (int i=0; i<(N + 1) * 60 * 60; i++) {
            h = i / 3600;
            m = i / 60 % 60;
            s = i % 60;
            ans += h / 10 == K || h % 10 == K || m / 10 == K || m % 10 == K || s / 10 == K || s % 10 == K ? 1 : 0;
        }

        System.out.print(ans);
    }
}

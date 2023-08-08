package chap04_Greedy;

import java.util.Scanner;

public class b11047 {

    public static void main(String[] args) {

        int N, K, ans = 0;
        int[] cost;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        cost = new int[N];

        for (int i=N-1; i>=0; i--)
            cost[i] = sc.nextInt();
        sc.close();

        for (int value : cost)
            if (value <= K) {
                ans += K / value;
                K %= value;
            }

        System.out.print(ans);

    }
}

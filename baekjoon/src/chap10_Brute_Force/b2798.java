package chap10_Brute_Force;

import java.util.Scanner;

public class b2798 {

    public static void main(String[] args) {

        int N, M, tmp, ans = 0;
        int[] cards;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        cards = new int[N];
        for (int i=0; i<N; i++)
            cards[i] = sc.nextInt();

        sc.close();

        bruteforce:
        for (int i=0; i<N-2; i++)
            for (int j=i+1; j<N-1; j++)
                for (int k=j+1; k<N; k++) {
                    tmp = cards[i] + cards[j] + cards[k];
                    ans = tmp <= M && ans < tmp ? tmp : ans;
                    if (ans == M)
                        break bruteforce;
                }

        System.out.print(ans);

    }

}

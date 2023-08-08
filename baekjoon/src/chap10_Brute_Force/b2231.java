package chap10_Brute_Force;

import java.util.Scanner;

public class b2231 {

    public static void main(String[] args) {

        int N, tmp, sum, ans = 0;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        for (int i=1; i<N; i++) {

            tmp = i;
            sum = i;

            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == N) {
                ans = i;
                break;
            }

        }

        System.out.print(ans);

    }
}

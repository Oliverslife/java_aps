package ETC;

import java.util.Scanner;

public class b18185 {

    public static void main(String[] args) {

        int N, get2, get3, ans = 0;
        int[] factory;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        factory = new int[N+2];

        for (int i=0; i<N; i++)
            factory[i] = sc.nextInt();

        sc.close();

        for (int i=0; i<N; i++) {

            if (factory[i+1] > factory[i+2]) {
                get2 = Math.min(factory[i], factory[i+1] - factory[i+2]);
                factory[i] -= get2;
                factory[i+1] -= get2;
                ans += get2 * 5;

                get3 = Math.min(factory[i], Math.min(factory[i+1], factory[i+2]));
                factory[i] -= get3;
                factory[i+1] -= get3;
                factory[i+2] -= get3;
                ans += get3 * 7;
            } else {
                get3 = Math.min(factory[i], Math.min(factory[i+1], factory[i+2]));
                factory[i] -= get3;
                factory[i+1] -= get3;
                factory[i+2] -= get3;
                ans += get3 * 7;

                get2 = Math.min(factory[i], factory[i+1]);
                factory[i] -= get2;
                factory[i+1] -= get2;
                ans += get2 * 5;
            }
            ans += factory[i] * 3;

        }

        System.out.print(ans);

    }
}

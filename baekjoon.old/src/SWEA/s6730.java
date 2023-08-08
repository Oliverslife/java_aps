package SWEA;

import java.util.Scanner;

public class s6730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n, u, d, past, now;
        int t = sc.nextInt();

        for(int tc=1; tc<=t; tc++) {

            u = 0;
            d = 0;
            n = sc.nextInt()-1;
            past = sc.nextInt();

            while(n-- > 0) {
                now = sc.nextInt();
                u = now > past ? Math.max(u, now - past) : u;
                d = now < past ? Math.max(d, past - now) : d;
                past = now;
            }

            sb.append("#" + tc + " " + u + " " + d + "\n");
        }

        System.out.print(sb);

    }
}

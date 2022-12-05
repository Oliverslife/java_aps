package ETC;

import java.util.Scanner;
import java.util.StringTokenizer;

public class q10953 {
    public static void main(String[] args) {
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a, b;
        while(n-- > 0) {
            st = new StringTokenizer(sc.next(), ",");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(a + b);
        }
        sc.close();
    }
}

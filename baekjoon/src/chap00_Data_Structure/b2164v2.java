package chap00_Data_Structure;

import java.util.Scanner;

public class b2164v2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int tmp = 1, ans = 1;

        while(N != 1) {
            if(N - tmp <= 0) {
                ans = (N - tmp / 2) * 2;
                break;
            }
            tmp *= 2;
        }

        System.out.print(ans);

    }
}

package Selected_01_Greedy;

import java.util.Scanner;

public class q14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        while(n > 0) {
            if(n % 5 == 0) {
                ans += n / 5;
                break;
            }
            n -= 2;
            ans += 1;
        }

        if(n < 0)
            System.out.print(-1);
        else
            System.out.print(ans);
    }
}

package Chap14_정수론및조합론;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q9375 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            while(n-- > 0) {
                sc.next();
                String target = sc.next();

                map.put(target, map.getOrDefault(target, 0) + 1);
            }
            int ans = 1;
            for(int x : map.values())
                ans *= (x + 1);
            System.out.println(ans - 1);
        }
        sc.close();
    }
}

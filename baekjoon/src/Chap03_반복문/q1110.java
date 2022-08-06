package Chap03_반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int target = n;
        int cnt = 0;

        do {
            n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
            cnt++;
        } while (target != n);

        System.out.println(cnt);
    }
}

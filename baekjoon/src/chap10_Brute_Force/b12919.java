package chap10_Brute_Force;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class b12919 {

    public static void main(String[] args) {

        String str;
        boolean flag = false;

        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();

        sc.close();

        Queue<String> q = new ArrayDeque<>();
        q.offer(T);

        while (!q.isEmpty()) {

            str = q.poll();

            if (str.equals(S)) {
                flag = true;
                break;
            }

            if (str.length() > 1 && str.charAt(0) == 'B')
                q.offer(new StringBuilder(str.substring(1)).reverse().toString());

            if (str.length() > 1 && str.charAt(str.length() - 1) == 'A')
                q.offer(str.substring(0, str.length() - 1));

        }

        System.out.print(flag ? 1 : 0);

    }
}
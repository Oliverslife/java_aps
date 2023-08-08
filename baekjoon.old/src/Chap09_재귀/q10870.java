package Chap09_재귀;

import java.util.Scanner;

public class q10870 {
    static int f(int target) {
        switch(target) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return f(target-1) + f(target-2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(f(sc.nextInt()));
        sc.close();
    }
}

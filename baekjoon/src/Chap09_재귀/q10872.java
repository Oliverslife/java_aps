package Chap09_재귀;

import java.util.Scanner;

public class q10872 {
    static int f(int target) {
        if(target < 2)
            return 1;
        return target * f(target-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = f(sc.nextInt());
        sc.close();
        System.out.print(sum);
    }
}

package Chap01_입출력과사칙연산;

import java.util.Scanner;

public class q3003 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        int[] target = new int[]{1, 1, 2, 2, 2, 8};

        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < target.length; i++) {
            arr[i] = target[i] - arr[i];
            System.out.println(arr[i]);
        }
    }
}
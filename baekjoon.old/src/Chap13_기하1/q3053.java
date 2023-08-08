package Chap13_기하1;

import java.util.Scanner;

public class q3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        sc.close();

        System.out.printf("%.6f\n", d * d * Math.PI);
        System.out.printf("%.6f\n", 2 * d * d);
    }
}

package Chap13_기하1;

import java.util.Scanner;

public class q1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int xdis = Math.min(x, w-x);
        int ydis = Math.min(y, h-y);
        System.out.print(Math.min(xdis, ydis));
    }
}

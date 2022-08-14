package Chap13_기하1;

import java.util.Scanner;

public class q3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ansx = 0;
        int ansy = 0;
        int[] x = new int[3];
        int[] y = new int[3];
        for(int i=0; i<3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        if(x[0] == x[1])
            ansx = x[2];
        else if(x[0] == x[2])
            ansx = x[1];
        else
            ansx = x[0];
        if(y[0] == y[1])
            ansy = y[2];
        else if(y[0] == y[2])
            ansy = y[1];
        else
            ansy = y[0];
        System.out.print(ansx + " " + ansy);
    }
}

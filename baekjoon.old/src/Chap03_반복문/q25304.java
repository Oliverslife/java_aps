package Chap03_반복문;

import java.util.Scanner;

public class q25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int num = sc.nextInt();
        int sum = 0;
        int product = 0;
        int amount = 0;
        for(int i=0; i<num; i++) {
            product = sc.nextInt();
            amount = sc.nextInt();
            sum += product * amount;
        }
        sc.close();
        if (total == sum)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}

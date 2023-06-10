package chap10_Brute_Force;

import java.util.Scanner;

public class b19532 {

    public static void main(String[] args) {

        int[] input = new int[6];
        int tmp1, tmp2;

        Scanner sc = new Scanner(System.in);
        for (int i=0; i<6; i++)
            input[i] = sc.nextInt();
        sc.close();

        bruteforce:
        for (int x=-999; x<1000; x++)
            for (int y=-999; y<1000; y++) {
                tmp1 = input[0] * x + input[1] * y - input[2];
                tmp2 = input[3] * x + input[4] * y - input[5];
                if (tmp1 == 0 && tmp2 == 0) {
                    System.out.print(x + " " + y);
                    break bruteforce;
                }
            }

    }
}

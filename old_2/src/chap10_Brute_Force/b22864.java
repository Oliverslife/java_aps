package chap10_Brute_Force;

import java.util.Scanner;

public class b22864 {

    public static void main(String[] args) {

        int A, B, C, M, pirodo = 0, work = 0;

        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        for (int i=0; i<24; i++) {
            if (pirodo + A > M)
                pirodo -= pirodo < C ? pirodo : C;
            else {
                work += B;
                pirodo += A;
            }
        }

        System.out.print(work);

    }
}

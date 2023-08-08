package ETC;

import java.math.BigInteger;
import java.util.Scanner;

public class q2338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        sc.close();
        System.out.print(a.add(b) + "\n" + a.subtract(b) + "\n" + a.multiply(b));

    }
}

package Chap06_문자열;

import java.util.Scanner;

public class q11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //필요 없는 값
        String str = sc.next();
        sc.close();
        int sum = 0;
        for(char ch : str.toCharArray()) {
            sum += Character.getNumericValue(ch);
        }
        System.out.print(sum);
    }
}

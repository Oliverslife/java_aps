package d2;

import java.util.Arrays;
import java.util.Scanner;

public class q1989 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String x = sc.next();
            String[] a = new String[x.length()];
            String[] b = new String[x.length()];
            
            for(int i=0; i<x.length(); i++) {
                a[i] = x.substring(i, i+1);
            }
            
            for(int i=0; i<x.length(); i++) {
                b[i] = a[(x.length()-1)-i];
            }
            
            if(Arrays.equals(a, b)) {
                System.out.printf("#%d %d\n", test_case, 1);
            }
            else {
                System.out.printf("#%d %d\n", test_case, 0);
            }
		}

	}

}

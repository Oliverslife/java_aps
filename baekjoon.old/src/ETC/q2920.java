package ETC;

import java.util.Scanner;

public class q2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for(int i=0; i<arr.length; i++)
            arr[i] = sc.nextInt();
        sc.close();

        String ans = "";
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1] - 1)
                ans = "ascending";
            else if(arr[i] == arr[i+1] + 1)
                ans = "descending";
            else {
                ans = "mixed";
                break;
            }
        }
        System.out.print(ans);
    }
}

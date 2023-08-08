package Chap05_함수;

public class q4673 {
    static boolean[] arr = new boolean[10001];

    static int d(int n) {
        int target = n;
        while(n != 0) {
            target += n % 10;
            n /= 10;
        }
        if(target <= 10000) {
            arr[target] = true;
            d(target);
        }
        return target;
    }

    public static void main(String[] args) {

        for(int i=1; i<arr.length; i++) {
            if(!arr[i])
                d(i);
            if(!arr[i])
                System.out.println(i);
        }
    }
}


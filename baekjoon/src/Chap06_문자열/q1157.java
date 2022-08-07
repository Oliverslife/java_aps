package Chap06_문자열;

import java.io.*;

public class q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        int max = Integer.MIN_VALUE;
        char ans = '?';

        String target = br.readLine().toUpperCase();
        for(byte b : target.getBytes()) {
            arr[b - 'A']++;
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                ans = (char)(i + 'A');
            }
            else if(arr[i] == max)
                ans = '?';
        }
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
}

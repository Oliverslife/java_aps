package Chap06_문자열;

import java.io.*;
import java.util.Arrays;

public class q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ans = new int[26];
        Arrays.fill(ans, -1);
        int idx = 0;

        String target = br.readLine().toLowerCase();
        for(char ch : target.toCharArray()) {
            if(ans[Character.getNumericValue(ch)-10] != -1) {           //ans의 대괄호 안에 ch-'a'로 사용 가능.
                idx++;
                continue;
            }
            ans[ch - 'a'] = idx++;
        }
        for(int i : ans) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

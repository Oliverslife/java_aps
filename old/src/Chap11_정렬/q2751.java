package Chap11_정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q2751 {
    static int[] cntsort(int[] arr, int max) {
        int[] result = new int[arr.length];
        int[] cnt = new int[max + 1];

        //개수 세기
        for(int i=0; i<arr.length; i++) {
            cnt[arr[i]]++;
        }

        //누적합 만들기
        for(int i=1; i<max + 1; i++) {
            cnt[i] += cnt[i-1];
        }

        //정렬하기
        for(int i=max; i>=0; i--) {
            if(cnt[i] > 0)
                result[--cnt[i]] = i;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) + 1000000;
            max = Math.max(max, arr[i]);
        }
        arr = cntsort(arr, max);
        int tmp;
        for(int x : arr) {
            tmp = x - 1000000;
            bw.write(tmp + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

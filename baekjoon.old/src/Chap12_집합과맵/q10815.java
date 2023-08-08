package Chap12_집합과맵;

import java.io.*;
import java.util.*;

public class q10815 {
    static int search(int[] arr, int n, int target) {
        int start = 0;
        int end = n - 1;
        int idx;

        while(start <= end) {
            idx = (start + end) / 2;
            if(arr[idx] == target)
                return 1;
            if(arr[idx] < target)
                start = idx + 1;
            else
                end = idx - 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tmp;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            tmp = Integer.parseInt(st.nextToken());
            bw.write(search(arr, n, tmp) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

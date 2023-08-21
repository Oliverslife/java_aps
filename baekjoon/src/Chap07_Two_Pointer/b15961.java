package Chap07_Two_Pointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * sliding window
 */
public class b15961 {

    public static int stoi(String str) { return Integer.parseInt(str); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, d, k, c, tmp = 0, ans = 0;
        int[] arr, selected;

        N = stoi(st.nextToken());   // 회전 초밥 벨트에 놓은 접시의 수
        d = stoi(st.nextToken());   // 초밥의 가짓수
        k = stoi(st.nextToken());   // 연속해서 먹는 접시의 수
        c = stoi(st.nextToken());   // 쿠폰 번호

        arr = new int[N];
        selected = new int[d + 1];

        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i=0; i<k; i++) {
            if (selected[arr[i]] == 0) tmp++;
            selected[arr[i]]++;
        }
        ans = selected[c] == 0 ? tmp + 1 : tmp;

        for (int i=0; i<N; i++) {
            if (selected[arr[(i + k) % N]] == 0) tmp++;
            selected[arr[(i + k) % N]]++;
            selected[arr[i]]--;
            if (selected[arr[i]] == 0) tmp--;
            ans = Math.max(ans, selected[c] == 0 ? tmp + 1 : tmp);
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
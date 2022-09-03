package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q1182 {

    static int n, s, ans = 0;
    static int[] arr;

    static void check(int depth, int sum) {

        if(depth == n) {    //선택하지 않는 경우를 함께 고려하기 때문에 depth == n 내부에서 s값 조건을 확인해도 됨.
            if(sum == s)
                ans++;
            return;
        }

        check(depth + 1, sum + arr[depth]);
        check(depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        s = Integer.parseInt(st.nextToken());
        if(s == 0)
            ans--;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        check(0, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

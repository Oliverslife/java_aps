package Chap07_Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 포인터 위치 실수로 오래걸린 케이스... 꼼꼼히 확인하자
 */
public class b22862 {

    static int N, K;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++)
            S[i] = Integer.parseInt(st.nextToken());

        br.close();

        int start = 0, end = 0, delete = 0, len = 0, ans = 0;
        while (end < N) {

            while (delete < K && end < N) {
                if (S[end++] % 2 != 0)  // 문제의 end++ 부분
                    delete++;
                else
                    len++;
            }

            while (end < N - 1 && S[end] % 2 == 0) {    // 이 부분에서 end++를 고려하지 않고 S[end + 1] 을 검증하느라 틀렸었음.
                end++;
                len++;
            }

            ans = Math.max(ans, len);

            if (S[start++] % 2 != 0)
                delete--;
            else
                len--;
        }

        System.out.println(ans);
    }
}
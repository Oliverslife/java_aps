import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * solving...
 */
public class Main {

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

            while (end < N && delete < K) {
                if (S[end++] % 2 != 0)
                    delete++;
                else
                    len++;
            }

            while (end < N - 1 && S[end + 1] % 2 == 0) {
                end++;
                len++;
            }

            ans = Math.max(ans, len);
            if (S[start++] % 2 != 0)
                delete--;
            else
                len--;
        }

        System.out.println(len);
    }
}
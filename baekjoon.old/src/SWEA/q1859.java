package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1859 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int X = Integer.parseInt(br.readLine());
        for(int i=1; i<=X; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }
            long ans = 0;
            int max = price[N-1];
            for(int j=N-2; j>=0; j--) {
                int now = price[j];
                if(max > now) {
                    ans += max - now;
                }
                else {
                    max = now;
                }
            }
            sb.append(String.format("#%d %d\n", i, ans));
             
        }
        System.out.println(sb);
        br.close();
	}
}

package d2;

import java.util.*;
import java.io.*;

public class q1284 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int P, Q, R, S, W, B, ans;

		int T = Integer.parseInt(br.readLine());		
		for(int i=1; i<=T; i++) {
			ans = 0;
			B = 0;
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			B = W < R ? Q : Q + ((W - R) * S);
			ans = P * W > B ? B : P * W;
			
			bw.write(String.format("#%d %d", i, ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

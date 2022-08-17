package d2;

import java.util.*;
import java.io.*;

public class q1285 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		StringTokenizer st;
		int N;
		int ans1;
		int ans2;

		int T = Integer.parseInt(br.readLine());		
		for(int i=1; i<=T; i++) {
			ans1 = 100000;
			ans2 = 1;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			for(int x : list) {
				if(ans1 > Math.abs(x)) {
					ans1 = Math.abs(x);
					ans2 = 1;
				}
				else if(ans1 == Math.abs(x))
					ans2++;
			}		
			
			bw.write(String.format("#%d %d %d", i, ans1, ans2));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}

package d2;

import java.util.*;
import java.io.*;

public class q1979 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		StringTokenizer st;
		int cnt;
		int ans;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N+1][N+1];
			
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}		
			
			ans = 0;
			
			for(int j=0; j<N+1; j++) {
				cnt = 0;
				for(int k=0; k<N+1; k++) {
					if(map[j][k] == 1) {
						cnt++;
						continue;
					}
					else {
						if(cnt == K) {
							ans++;
							cnt = 0;
						}
						else {
							cnt = 0;
						}
					}
				}
			}		
			
			for(int j=0; j<N+1; j++) {
				cnt = 0;
				for(int k=0; k<N+1; k++) {
					if(map[k][j] == 1) {
						cnt++;
						continue;
					}
					else {
						if(cnt == K) {
							ans++;
							cnt = 0;
						}
						else {
							cnt = 0;
						}
					}
				}
			}
			
			bw.write(String.format("#%d %d", i, ans));
			bw.newLine();		
			
		}		
		bw.flush();
		bw.close();
		br.close();

	}

}

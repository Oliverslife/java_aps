package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q2001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		int ans;
		int max;
		for(int a=1; a<=T; a++) {
			max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {					
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					ans = 0;
					for(int k=0; k<M; k++) {
						for(int l=0; l<M; l++) {
							ans += map[i+k][j+l];
						}
					}
					max = ans > max ? ans : max;
				}
			}
			bw.write(String.format("#%d %d", a, max));
			bw.newLine();			
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

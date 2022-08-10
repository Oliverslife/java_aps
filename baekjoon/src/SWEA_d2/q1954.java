package d2;

import java.util.*;
import java.io.*;

public class q1954 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int[][] ans;
		int num;
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int r;
		int c;
		int idx;

		int T = Integer.parseInt(br.readLine());		
		for(int i=1; i<=T; i++) {			
			N = Integer.parseInt(br.readLine());
			ans = new int[N][N];
			num = 1;
			r = 0;
			c = 0;
			idx = 0;
			bw.write(String.format("#%d ", i));
			bw.newLine();
			while(num < N*N) {				
				ans[r][c] = num++;				
				if(r+dr[idx] >= 0 && r+dr[idx] < N && c+dc[idx] >= 0 && c+dc[idx] < N && ans[r+dr[idx]][c+dc[idx]] == 0) {
					r += dr[idx];
					c += dc[idx];					
				}
				else {
					idx++;
					num--;
					if(idx == 4)
						idx = 0;
				}			
			}
			ans[r][c] = num;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					bw.write(String.format("%d ", ans[j][k]));
				}
				bw.newLine();;
			}
			
		}
		bw.flush();
		bw.close();
		br.close();

	}

}

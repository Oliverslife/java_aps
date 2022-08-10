package d2;

import java.util.*;
import java.io.*;

public class q1959 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		int M;
		int[] nmap;
		int[] mmap;
		int tmp;
		int ans;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			nmap = new int[N];
			mmap = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {				
				nmap[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mmap[j] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			if(N > M) {
				for(int j=0; j<N-M+1; j++) {
					tmp = 0;
					for(int k=0; k<M; k++) {
						tmp += nmap[j+k] * mmap[k];
					}
					ans = Math.max(tmp, ans);
				}
			}
			else {
				for(int j=0; j<M-N+1; j++) {
					tmp = 0;
					for(int k=0; k<N; k++) {
						tmp += mmap[j+k] * nmap[k];
					}
					ans = Math.max(tmp, ans);
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

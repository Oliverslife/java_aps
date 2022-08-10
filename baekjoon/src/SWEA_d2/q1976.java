package d2;

import java.util.*;
import java.io.*;

public class q1976 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M;
		int H;
		int x;
		
		int T = Integer.parseInt(br.readLine());		
		for(int i=1; i<=T; i++) {			
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());		
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());				
			
			M = m1 + m2 > 60 ? (m1 + m2) % 60 : m1 + m2;			
			x = m1 + m2 > 60 ? 1 : 0;
			H = h1 + h2 + x > 12 ? (h1 + h2 + x) % 12 : h1 + h2 + x;
			H = H == 0 ? 12 : H;
			
			bw.write(String.format("#%d %d %d", i, H, M));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}

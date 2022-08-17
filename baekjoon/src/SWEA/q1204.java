package d2;

import java.util.*;
import java.io.*;

public class q1204 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max;
		int idx;
		int[] freq;
		
		int T = Integer.parseInt(br.readLine());		
		for(int i=1; i<=T; i++) {
			max = 0;
			idx = 0;
			freq = new int[101];			
			br.readLine();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				freq[Integer.parseInt(st.nextToken())]++;
			}
			for(int j=1; j<=100; j++) {
				if(freq[j] > max) {
					max = freq[j];
					idx = j;
				}
				else if(freq[j] == max && j > idx) {
					idx = j;					
				}
			}
			bw.write(String.format("#%d %d", i, idx));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}

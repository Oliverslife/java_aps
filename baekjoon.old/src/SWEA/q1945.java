package d2;

import java.util.*;
import java.io.*;

public class q1945 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int target;
		int[] num = {2, 3, 5, 7, 11};
		int[] ans;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			ans = new int[5];
			target = Integer.parseInt(br.readLine());
			
			while(target != 1) {
				for(int j=0; j<num.length; j++) {
					if(target % num[j] == 0) {
						target /= num[j];
						ans[j]++;
					}
				}			
			}
			
			bw.write(String.format("#%d %d %d %d %d %d", i, ans[0], ans[1], ans[2], ans[3], ans[4]));
			bw.newLine();
		}		
		bw.flush();
		bw.close();
		br.close();

	}

}

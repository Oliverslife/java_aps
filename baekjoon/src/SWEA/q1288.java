package d2;

import java.util.*;
import java.io.*;

public class q1288 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String target;
		int std;
		int[] check;
		int count;		
		int ans;
		
		int T = Integer.parseInt(br.readLine());		
		for(int i=1; i<=T; i++) {
			target = br.readLine();
			std = Integer.parseInt(target);			
			check = new int[10];
			count = 0;			
			ans = 1;
			
			while(true) {					
				for(int j=0; j<target.length(); j++) {
					if(check[Integer.parseInt(target.substring(j, j+1))]==0) {
						check[Integer.parseInt(target.substring(j, j+1))]++;
						count++;						
					}
				}
				
				if(count != 10) {
					target = String.valueOf(Integer.parseInt(target) + std);
					ans++;
					continue;
				}
				else {
					break;
				}
			}
			
			bw.write(String.format("#%d %d", i, ans*std));
			bw.newLine();	
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

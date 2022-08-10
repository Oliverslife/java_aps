package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q1206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		StringTokenizer st;
		
		int ans;
		int width;
		int r1, r2, l1, l2;		
		
		for(int i=0; i<10; i++) {
			list.clear();
			ans = 0;
			width = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}			
			for(int j=2; j<width-2; j++) {
				r1 = list.get(j) - list.get(j+1);
				r2 = list.get(j) - list.get(j+2);
				l1 = list.get(j) - list.get(j-1);				
				l2 = list.get(j) - list.get(j-2);
				if(r1 > 0 && r2 > 0 && l1 > 0 && l2 > 0)
					ans += Math.min(Math.min(r1, r2), Math.min(l1, l2));
			}			
			bw.write(String.format("#%d %d", i+1, ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();		
	}
}

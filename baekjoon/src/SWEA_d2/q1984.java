package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q1984 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		double ans;
		double tmp;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			list.clear();
			ans = 0;
			tmp = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			list.remove(Collections.max(list));
			list.remove(Collections.min(list));
			for(int x : list) {
				tmp += x;
			}
			ans = tmp / list.size();		
			bw.write(String.format("#%d %.0f", i, ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

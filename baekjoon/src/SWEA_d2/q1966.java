package d2;

import java.util.*;
import java.io.*;

public class q1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
            list.clear();
			br.readLine();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			bw.write(String.format("#%d ", i));
			Collections.sort(list);;
			for(int x : list) {
				bw.write(x + " ");
			}
			bw.newLine();
		}		
		bw.flush();
		bw.close();
		br.close();

	}

}

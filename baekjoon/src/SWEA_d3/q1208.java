package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		StringTokenizer st;
		for(int i=1; i<=10; i++) {
			list.clear();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);
			for(int j=0; j<n; j++) {
				list.set(list.size()-1, list.get(list.size()-1) - 1);
				list.set(0, list.get(0) + 1);
				Collections.sort(list);
			}
			bw.write("#" + i + " " + (list.get(list.size()-1) - list.get(0)) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

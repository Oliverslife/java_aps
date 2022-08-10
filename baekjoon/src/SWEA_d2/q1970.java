package d2;

import java.util.*;
import java.io.*;

public class q1970 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			bw.write(String.format("#%d", i));
			bw.newLine();
			int target = Integer.parseInt(br.readLine());
			int ans1 = target / 50000;
			target %= 50000;
			int ans2 = target / 10000;
			target %= 10000;
			int ans3 = target / 5000;
			target %= 5000;
			int ans4 = target / 1000;
			target %= 1000;
			int ans5 = target / 500;
			target %= 500;
			int ans6 = target / 100;
			target %= 100;
			int ans7 = target / 50;
			target %= 50;
			int ans8 = target / 10;
			target %= 10;
			bw.write(String.format("%d %d %d %d %d %d %d %d", ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

package d2;

import java.util.*;
import java.io.*;

public class q1948 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		long diff;		

		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {			
			st = new StringTokenizer(br.readLine());
			day1.set(Calendar.YEAR, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
			day2.set(Calendar.YEAR, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
			diff = ((day2.getTimeInMillis() - day1.getTimeInMillis())/1000)/(24*60*60) + 1;
			
			bw.write(String.format("#%d %d", i, diff));			
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

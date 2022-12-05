package d2;

import java.util.*;
import java.io.*;

public class q1928 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());		
		for(int i=1; i<=T; i++) {
			String str = br.readLine();
			str = new String(Base64.getDecoder().decode(str));					
			
			bw.write(String.format("#%d %s", i, str));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

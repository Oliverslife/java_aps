package d2;

import java.util.*;
import java.io.*;
//쓰레기문제
public class q1940 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;		

		int spd;
		int mov;
		int select;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			spd = 0;
			mov = 0;			
			for(int j=0; j<N; j++) {				
				st = new StringTokenizer(br.readLine());
				select = Integer.parseInt(st.nextToken());				
				switch(select) {
				case 1:
					spd += Integer.parseInt(st.nextToken());
					break;
				case 2:
					spd -= Integer.parseInt(st.nextToken());
					if(spd < 0)
						spd = 0;
					break;
				case 0:				
				}
				mov += spd;
			}
			bw.write(String.format("#%d %d", i, mov));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

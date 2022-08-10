package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q1986 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int ans;
		int tmp;
		for(int i=1; i<=T; i++) {	
			ans = 0;
			tmp = Integer.parseInt(br.readLine());
			for(int j=1; j<=tmp; j++) {
				if(j % 2 != 0)
					ans += j;
				else
					ans -= j;
			}
			bw.write(String.format("#%d %d", i, ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

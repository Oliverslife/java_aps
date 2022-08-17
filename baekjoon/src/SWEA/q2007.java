package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q2007 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String check;
		int ans;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			ans = 0;
			check = br.readLine();
			for(int j=1; j<=10; j++) {
				if(check.substring(0, j).equals(check.substring(j, j+j))) {
					ans = j;
					break;
				}
			}
			bw.write(String.format("#%d %d", i, ans));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

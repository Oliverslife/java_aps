package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q2005 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int row;
		int n = Integer.parseInt(br.readLine());		
		
		for(int i=0; i<n; i++) {
			bw.write(String.format("#%d", i+1));
			bw.newLine();			
			row = Integer.parseInt(br.readLine());
			int[][] tri = new int[row][row];
			for(int j=0; j<row; j++) {
				for(int k=0; k<=j; k++) {
					if(j == k || k == 0)
						tri[j][k] = 1;
					else
						tri[j][k] = tri[j-1][k-1] + tri[j-1][k];
					bw.write(tri[j][k] + " ");
				}
				bw.newLine();
			}				
			
		}		
		bw.flush();
		bw.close();
		br.close();
	}

}

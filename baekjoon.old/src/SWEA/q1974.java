package d2;

import java.util.*;
import java.io.*;

public class q1974 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<Integer> set = new HashSet<>();
		StringTokenizer st;
		int[][] sudoku = new int[9][9];
		int ans;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			ans = 1;
			for(int j=0; j<9; j++) {
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					set.clear();
					for(int k=0; k<9; k++) {
						sudoku[j][k] = Integer.parseInt(st.nextToken());
						set.add(sudoku[j][k]);
					}
					if(set.size() != 9) {
						ans = 0;
						break;
					}
				}				
			}
			
			if(ans != 0) {
				for(int j=0; j<9; j++) {
					set.clear();
					for(int k=0; k<9; k++) {
						set.add(sudoku[k][j]);
					}
					if(set.size() != 9) {
						ans = 0;
						break;
					}
				}
			}
			
			if(ans != 0) {
				for(int j=1; j<=3; j++) {
					set.clear();
					for(int k=j*3-1; k>=j*3-3; k--) {						
						for(int l=j*3-1; l>=j*3-3; l--) {
							set.add(sudoku[k][l]);
						}						
					}
					if(set.size() != 9) {
						ans = 0;
						break;
					}
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

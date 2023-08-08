package d2;

import java.util.*;
import java.io.*;

public class q1961 {
	
	public static int[][] rot(int[][] map) {
		int[][] result = new int[map.length][map.length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				result[j][Math.abs(i-map.length+1)] = map[i][j];
			}
		}		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] map;
		int[][] r90;
		int[][] r180;
		int[][] r270;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			r90 = rot(map);
			r180 = rot(r90);
			r270 = rot(r180);
			
			bw.write(String.format("#%d", i));
			bw.newLine();
			for(int j=0; j<N; j++) {
				for(int k=0; k<map.length; k++) {
					bw.write(String.valueOf(r90[j][k]));
				}
				bw.write(" ");
				for(int k=0; k<map.length; k++) {
					bw.write(String.valueOf(r180[j][k]));
				}
				bw.write(" ");
				for(int k=0; k<map.length; k++) {
					bw.write(String.valueOf(r270[j][k]));
				}
				bw.newLine();
			}	
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

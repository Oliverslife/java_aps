package d2;

import java.io.*;
import java.util.*;

public class q1983 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Double> list = new ArrayList<>();
        double score;
        int rank;
        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
         
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {            
            rank = 0;
             
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                score = Integer.parseInt(st.nextToken())*0.35 + Integer.parseInt(st.nextToken())*0.45 + Integer.parseInt(st.nextToken())*0.2;
                list.add(score);
            }
            for(double x : list) {
                if(x > list.get(K-1)) {
                    rank++;
                }                   
            }           
            bw.write(String.format("#%d %s", i, grade[rank/(N/10)]));
            rank = 0;
            list.clear();
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
	}

}

package Chap10_브루트포스;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<list.size()-2; i++) {
            for(int j=i+1; j<list.size()-1; j++) {
                for(int k=j+1; k<list.size(); k++) {
                    sum = list.get(i) +  list.get(j) + list.get(k);
                    if(sum <= M && sum > ans)
                        ans = sum;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

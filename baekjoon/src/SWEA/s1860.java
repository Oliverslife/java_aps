package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class s1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list;
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            list = new ArrayList<>();
            String ans = "Possible";

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                list.add(Integer.parseInt(st.nextToken()));
            Collections.sort(list);                                 //주어진 입력데이터 처리 완료

            for(int j=0; j<n; j++)
                if((list.get(j) / m) * k < j + 1) {                 //i초까지 만든 붕어빵이 손님 수보다 적으면
                    ans = "Impossible";
                    break;
                }

            bw.write(String.format("#%d %s\n", i, ans));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

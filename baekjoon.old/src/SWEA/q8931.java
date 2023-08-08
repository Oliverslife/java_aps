package SWEA;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class q8931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> d;
        int ans;

        int tc = Integer.parseInt(br.readLine());
        for(int i=1; i<=tc; i++) {
            ans = 0;
            d = new LinkedList<>();
            int k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                int tmp = Integer.parseInt(br.readLine());
                if(tmp == 0)
                    d.pop();
                else
                    d.push(tmp);
            }
            while(!d.isEmpty())
                ans += d.poll();
            bw.write(String.format("#%d %d\n", i, ans));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

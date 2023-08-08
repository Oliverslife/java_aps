package Selected_02_DataStructure;

import java.io.*;
import java.util.*;

public class q22942 {
    static String ans = "guesswhat";
    static class HalfCircle implements Comparable<HalfCircle> {
        int point, idx;
        public HalfCircle(int point, int idx) {
            this.point = point;
            this.idx = idx;
        }

        @Override
        public int compareTo(HalfCircle o) {
            if(this.point == o.point)
                ans = "NO";
            return  o.point - this.point;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<HalfCircle> list = new ArrayList<>();
        Stack<HalfCircle> stack = new Stack<>();
        StringTokenizer st;
        int x, r;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            list.add(new HalfCircle(x-r, i));
            list.add(new HalfCircle(x+r, i));
        }
        Collections.sort(list);

        for(HalfCircle c : list) {
            if(stack.isEmpty())
                stack.push(c);
            else if(stack.peek().idx == c.idx)
                stack.pop();
            else
                stack.push(c);
        }

        ans = ans.equals("guesswhat") && stack.isEmpty() ? "YES" : "NO";
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
}

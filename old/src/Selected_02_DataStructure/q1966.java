package Selected_02_DataStructure;

import java.io.*;
import java.util.*;

public class q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Map.Entry<Integer, Integer>> d;
        Queue<Integer> q;
        StringTokenizer st;
        int ans, n, m;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            ans = 1;
            d = new LinkedList<>();
            q = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                d.offer(new AbstractMap.SimpleEntry<>(i, Integer.parseInt(st.nextToken())));
                q.offer(d.peekLast().getValue());
            }
            while(true) {
                if(q.peek() != d.peek().getValue())
                    d.offer(d.poll());
                else {
                    if(d.peek().getKey() == m)
                        break;
                    d.poll();
                    q.poll();
                    ans++;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

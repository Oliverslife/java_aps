package Selected_02_DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Map.Entry<Integer, Integer>> d = new ArrayDeque<>();  //LinkedList 메모리초과
        Map.Entry<Integer, Integer> tmp;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++)
            d.offer(new AbstractMap.SimpleEntry(i, Integer.parseInt(st.nextToken())));

        while(!d.isEmpty()) {
            tmp = d.poll();
            sb.append(tmp.getKey() + " ");
            if(!d.isEmpty() && tmp.getValue() > 0)	//풍선 속 번호가 양수
                for(int j=0; j<tmp.getValue()-1; j++)
                    d.offer(d.poll());
            else if(!d.isEmpty() && tmp.getValue() < 0)
                for(int j=0; j<Math.abs(tmp.getValue()); j++)
                    d.offerFirst(d.pollLast());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

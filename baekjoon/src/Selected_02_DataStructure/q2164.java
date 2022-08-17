package Selected_02_DataStructure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class q2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> d = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++)
            d.offer(i);
        while(d.size() != 1) {
            d.poll();
            d.offer(d.poll());
        }
        bw.write(d.poll() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

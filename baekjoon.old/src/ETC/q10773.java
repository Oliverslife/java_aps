package ETC;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> d = new LinkedList<>();
        int ans = 0;

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

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

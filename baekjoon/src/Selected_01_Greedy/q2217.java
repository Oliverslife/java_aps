package Selected_01_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0;

        int n = Integer.parseInt(br.readLine());
        List<Integer> rope = new ArrayList<>();

        for(int i=0; i<n; i++) {
            rope.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(rope, Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            ans = Math.max(rope.get(i) * (i+1), ans);
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

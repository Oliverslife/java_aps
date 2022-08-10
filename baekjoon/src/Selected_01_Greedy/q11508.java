package Selected_01_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        int ans = 0;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            if(i % 3 != 2)
                ans += list.get(i);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

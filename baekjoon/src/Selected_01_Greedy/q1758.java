package Selected_01_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> tips = new ArrayList<>();
        long ans = 0;
        int tmp;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            tips.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(tips, Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            tmp = tips.get(i) - i;
            if(tmp <= 0)
                break;
            ans += tmp;
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

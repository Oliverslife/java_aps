package ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q25576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<int[]> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            int[] arr = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            list.add(arr);
        }

        int a = 0;  //사이 좋음
        int b = 0;  //사이 안좋음
        String ans = "NO";
        for(int i=1; i<n; i++) {
            int tmp = 0;
            for(int j=0; j<m; j++) {
                tmp += Math.abs(list.get(0)[j] - list.get(i)[j]);
                if(tmp > 2000) {
                    b++;
                    break;
                }
            }
            if(tmp <= 2000)
                a++;
        }
        if(b >= a)
            ans = "YES";
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

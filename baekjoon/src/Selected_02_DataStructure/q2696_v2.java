package Selected_02_DataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q2696_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb;
        List<Integer> list;
        int M, checker;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            list = new ArrayList<>();
            sb = new StringBuilder();
            checker = 0;

            M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2).append("\n");
            for(int i=0; i<M; i++) {
                if(i % 10 == 0)
                    st = new StringTokenizer(br.readLine());
                list.add(Integer.parseInt(st.nextToken()));
                Collections.sort(list);

                if(i % 2 == 0) {
                    if(checker == 9 || i == M - 1) {
                        sb.append(list.get(i / 2) + "\n");
                        checker = 0;
                    }
                    else
                        sb.append(list.get(i / 2) + " ");
                }
                checker++;
            }
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

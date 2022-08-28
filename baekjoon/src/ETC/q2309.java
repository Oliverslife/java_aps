package ETC;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int total = 0, target1 = 0, target2 = 0, tmp;

        for(int i=0; i<9; i++) {
            tmp = Integer.parseInt(br.readLine());
            list.add(tmp);
            total += tmp;
        }
        Collections.sort(list);

        loop:
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                tmp = total - list.get(i) - list.get(j);
                if(tmp == 100) {
                    target1 = i;
                    target2 = j;
                    break loop;
                }
            }
        }

        list.remove(target2);
        list.remove(target1);

        for(int x : list)
            sb.append(x + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

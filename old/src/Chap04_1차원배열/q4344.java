package Chap04_1차원배열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Double> list = new ArrayList<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int head;
        double avg;
        double cnt;

        for(int i=0; i<n; i++) {
            list.clear();
            st = new StringTokenizer(br.readLine());
            head = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()) {
                list.add(Double.parseDouble(st.nextToken()));
            }

            avg = list.stream().mapToDouble(Double::doubleValue).sum() / list.size();  //이거 신기하네
            cnt = 0;
            for(double d : list) {
                if(d > avg)
                    cnt++;
            }

            bw.write(String.format("%.3f%%", (cnt / head) * 100));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

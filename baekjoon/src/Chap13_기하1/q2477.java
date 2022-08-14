package Chap13_기하1;

import java.io.*;
import java.util.StringTokenizer;

public class q2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] data = new int[6];

        int tmp, dis, max, min, wmax = 0, widx = 0, hmax = 0, hidx = 0;
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine());
            tmp = Integer.parseInt(st.nextToken());
            dis = Integer.parseInt(st.nextToken());
            data[i] = dis;
            if(tmp == 1 || tmp == 2) {
                if(data[i] > wmax) {
                    wmax = data[i];
                    widx = i;
                }
            }
            else {
                if(data[i] > hmax) {
                    hmax = data[i];
                    hidx = i;
                }
            }
        }
        max = wmax * hmax;
        min = data[(widx+3) % 6] * data[(hidx+3) % 6];
        tmp = (max-min) * k;

        bw.write(tmp + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

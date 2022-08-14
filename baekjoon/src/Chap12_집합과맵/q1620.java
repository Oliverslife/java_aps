package Chap12_집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, String> itos = new HashMap<>();
        Map<String, Integer> stoi = new HashMap<>();
        String tmp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=1; i<n+1; i++) {
            tmp = br.readLine();
            itos.put(i, tmp);
            stoi.put(tmp, i);
        }

        for(int i=0; i<m; i++) {
            tmp = br.readLine();
            if(stoi.containsKey(tmp))
                bw.write(stoi.get(tmp) + "\n");
            else
                bw.write(itos.get(Integer.parseInt(tmp)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

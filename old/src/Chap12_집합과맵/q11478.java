package Chap12_집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class q11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        String tmp;

        String target = br.readLine();
        for(int i=0; i<target.length(); i++) {
            tmp = "";
            for(int j=i; j<target.length(); j++) {
                tmp += target.substring(j, j+1);
                set.add(tmp);
            }
        }

        bw.write(set.size() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

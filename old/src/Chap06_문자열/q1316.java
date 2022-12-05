package Chap06_문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class q1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Character> list = new ArrayList<>();

        int is_group;
        char tmp;
        int ans = 0;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {

            list.clear();
            is_group = 1;
            tmp = '\0';

            String target = br.readLine();
            for(char ch : target.toCharArray()) {
                if(tmp == ch)
                    continue;
                tmp = ch;
                if(list.contains(ch)) {
                    is_group = 0;
                    break;
                }
                list.add(ch);
            }
            ans += is_group;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

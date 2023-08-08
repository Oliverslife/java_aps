package Chap11_정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Character> list = new ArrayList<>();
        String str = br.readLine();
        for(char ch : str.toCharArray())
            list.add(ch);
        Collections.sort(list, Collections.reverseOrder());
        for(char ch : list)
            bw.write(ch + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

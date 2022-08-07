package Chap06_문자열;

import java.io.*;

public class q5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int ans = 0;

        for(char ch : target.toCharArray()) {
            if(ch >= 'A' && ch <= 'C')
                ans += 3;
            else if(ch >= 'D' && ch <= 'F')
                ans += 4;
            else if(ch >= 'G' && ch <= 'I')
                ans += 5;
            else if(ch >= 'J' && ch <= 'L')
                ans += 6;
            else if(ch >= 'M' && ch <= 'O')
                ans += 7;
            else if(ch >= 'P' && ch <= 'S')
                ans += 8;
            else if(ch >= 'T' && ch <= 'V')
                ans += 9;
            else if(ch >= 'W' && ch <= 'Z')
                ans += 10;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

package Selected_01_Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        int cnt = 0;

        String target = br.readLine();
        char tmp = '\0';
        for(char ch : target.toCharArray()) {

            if(tmp != ch && ch == 'M') {
                cnt++;
                min.append("1");
                if(min.length() == target.length()) {
                    for(int i=0; i<cnt; i++)
                        max.append("1");
                }
            }

            else if(tmp != ch && ch == 'K') {
                max.append("5");
                for(int i=0; i<cnt; i++)
                    max.append("0");
                min.append("5");
                cnt = 0;
            }

            else if(tmp == 'M' && ch == 'M') {
                cnt++;
                min.append("0");
                if(min.length() == target.length()) {
                    max.append("1");
                    for(int i=0; i<cnt-1; i++)
                        max.append("1");
                }
            }

            else if(tmp == 'K' && ch == 'K') {
                max.append("5");
                min.append("5");
            }

            tmp = ch;
        }
        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }
}
package ETC;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class q5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> d;
        Deque<Character> tmp;
        StringBuilder sb;
        String target;

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            d = new LinkedList<>();
            tmp = new LinkedList<>();
            sb = new StringBuilder();

            target = br.readLine();
            for(char ch : target.toCharArray()) {
                if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
                    d.push(ch);
                else if(!d.isEmpty() && ch == '-')
                    d.pop();
                else if(!d.isEmpty() && ch == '<')
                    tmp.push(d.pop());
                else if(!tmp.isEmpty() && ch == '>')
                    d.push(tmp.pop());
                else
                    continue;
            }
            while(!tmp.isEmpty())
                d.push(tmp.pop());
            while(!d.isEmpty())
                sb.append(d.pollLast());
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

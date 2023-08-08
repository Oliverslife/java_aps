package Selected_03_Backtracking;

import java.io.*;
import java.util.*;

public class q6443 {
    static StringBuilder sb = new StringBuilder();
    static char[] box, ansbox, test;
    static boolean[] visited;
    static void dfs(int depth, int len) {
        if(depth == len) {
            for(char ch : ansbox)
                sb.append(ch);
            sb.append("\n");
            return;
        }

        char past = '\0';
        for(int i=0; i<len; i++) {
            if(past == box[i])
                continue;
            if(!visited[i]) {
                past = box[i];
                visited[i] = true;
                ansbox[depth] = box[i];
                dfs(depth + 1, len);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            box = br.readLine().toCharArray();
            int len = box.length;
            ansbox = new char[len];
            test = new char[len];
            visited = new boolean[len];
            Arrays.sort(box);
            dfs(0, len);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
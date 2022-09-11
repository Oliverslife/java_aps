package Selected_04_BruteForce;

import java.io.*;

public class q12919_solving {
    static String S;
    static boolean checker = false;
    static StringBuilder sb;

    static void dfs(String T) {
        if(T.charAt(0) == 'A' && T.charAt(T.length() - 1) == 'B')
            return;

        if(S.length() == T.length()) {
            if(S.equals(T))
                checker = true;
            return;
        }

        if(T.charAt(T.length()-1) == 'A')
            dfs(T.substring(0, T.length()-1));
        if(T.charAt(0) == 'B') {
            sb = new StringBuilder(T.substring(1));
            dfs(sb.reverse().toString());
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        String T = br.readLine();

        dfs(T);

        int ans = checker ? 1 : 0;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

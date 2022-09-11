package Selected_03_Backtracking;

import java.io.*;

public class q2661 {    //q2580 스도쿠랑 비슷한 부분에서 시간을 낭비함
    static int n;
    static boolean isGood(String str) {
        for(int i=1; i<=str.length() / 2; i++)
            if(str.substring(str.length()-i-i, str.length()-i).equals(str.substring(str.length()-i)))
                return false;
        return true;
    }
    static void dfs(String str) {
        if(!isGood(str))
            return;

        if(str.length() == n) {
            System.out.print(str);
            System.exit(0);
        }

        for(int i=1; i<=3; i++)
            dfs(str + i);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i=1; i<=3; i++)
            dfs(Integer.toString(i));
    }
}
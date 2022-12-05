package ETC;

import java.io.*;

public class q1747 {
    static boolean check(String target) {
        return target.equals(new StringBuilder(target).reverse().toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        boolean[] sosu = new boolean[1004000];
        sosu[0] = sosu[1] = true;
        int n = Integer.parseInt(br.readLine());

        for(int i=2; i<=n; i++) {
            if(sosu[i])
                continue;
            for(int j=i*2; j<1004000; j+=i)
                sosu[j] = true;
        }

        for(int i=n; i<1004000; i++)
            if(check(String.valueOf(i)) && !sosu[i]) {
                ans = i;
                break;
            }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

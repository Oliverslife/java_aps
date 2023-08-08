package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q1990 {
    static boolean check(String target) {
        return target.equals(new StringBuilder(target).reverse().toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] sosu = new boolean[100000001];
        sosu[0] = sosu[1] = true;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i=2; i*i<=b; i++) {
            if(sosu[i])
                continue;
            for(int j=i*2; j<b+1; j+=i)
                sosu[j] = true;
        }

        for(int i=a; i<=b; i++)
            if(!sosu[i] && check(String.valueOf(i)))
                sb.append(i +"\n");
        sb.append("-1");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

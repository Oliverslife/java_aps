package ETC;

import java.io.*;

public class q2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String target = br.readLine();
        int r = 1, c;
        for(int i=1; i<=Math.sqrt(target.length()); i++)
            if(target.length() % i == 0)
                r = i;
        c = target.length() / r;

        for(int i=0; i<r; i++)
            for(int j=i; j<=i+(r*(c-1)); j+=r)
                sb.append(target.charAt(j));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

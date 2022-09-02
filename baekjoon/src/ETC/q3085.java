package ETC;

import java.io.*;

public class q3085 {
    static int n;
    static String[][] map;
    static int ans;

    static void eatCandy() {
        int how_many;
        for(int i=0; i<n; i++) {
            how_many = 1;
            for(int j=1; j<n; j++) {
                if(map[i][j].equals(map[i][j-1]))
                    how_many++;
                else
                    how_many = 1;
                ans = Math.max(ans, how_many);
            }
        }

        for(int i=0; i<n; i++) {
            how_many = 1;
            for(int j=1; j<n; j++) {
                if(map[j][i].equals(map[j-1][i]))
                    how_many++;
                else
                    how_many = 1;
                ans = Math.max(ans, how_many);
            }
        }
    }

    static void garoswap(int x, int y) {
        String tmp = map[x][y];
        map[x][y] = map[x][y+1];
        map[x][y+1] = tmp;
        eatCandy();
        tmp = map[x][y];
        map[x][y] = map[x][y+1];
        map[x][y+1] = tmp;
    }

    static void seroswap(int x, int y) {
        String tmp = map[x][y];
        map[x][y] = map[x+1][y];
        map[x+1][y] = tmp;
        eatCandy();
        tmp = map[x][y];
        map[x][y] = map[x+1][y];
        map[x+1][y] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp;

        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        for(int i=0; i<n; i++) {
            tmp = br.readLine().split("");
            for(int j=0; j<n; j++)
                map[i][j] = tmp[j];
        }

        for(int i=0; i<n; i++)
            for(int j=0; j<n-1; j++)
                garoswap(i, j);

        for(int i=0; i<n-1; i++)
            for(int j=0; j<n; j++)
                seroswap(i, j);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q16918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] start = new char[r][c];//초기 상태
        char[][] a2 = new char[r][c];	//초기 폭발 직후
        char[][] a3 = new char[r][c];
        char[][] fill = new char[r][c];	//폭탄 채우기
        char[][] ans = new char[r][c];

        for(int i=0; i<r; i++)
            start[i] = br.readLine().toCharArray();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++) {
                fill[i][j] = 'O';
                if(start[i][j] == '.')
                    continue;
                a2[i][j] = '.';
                for(int k=0; k<4; k++) {
                    if(i+dr[k] >= 0 && i+dr[k] < r && j+dc[k] >=0 && j+dc[k] < c)
                        a2[i+dr[k]][j+dc[k]] = '.';
                }
            }

        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                a2[i][j] = a2[i][j] != '.' ? 'O' : '.';

        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++) {
                if(a2[i][j] == '.')
                    continue;
                a3[i][j] = '.';
                for(int k=0; k<4; k++) {
                    if(i+dr[k] >= 0 && i+dr[k] < r && j+dc[k] >=0 && j+dc[k] < c)
                        a3[i+dr[k]][j+dc[k]] = '.';
                }
            }

        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                a3[i][j] = a3[i][j] != '.' ? 'O' : '.';

        if(n % 2 == 0)
            ans = fill;
        else if(n / 2 % 2 == 1)
            ans = a2;
        else if(n / 2 % 2 == 0)
            ans = a3;

        if(n == 1)
            ans = start;


        for(int i=0; i<r; i++)
            sb.append(new String(ans[i])).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
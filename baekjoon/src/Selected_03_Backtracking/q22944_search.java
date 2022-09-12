package Selected_03_Backtracking;

import java.io.*;
import java.util.*;

public class q22944_search {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int []visit ;
    static int sx,sy,ex,ey;
    static int n ,h,d;
    static int ans =2100000000;
    static ArrayList<Entity> umb = new ArrayList<>();
    static class Entity
    {
        int x,y;

        public Entity(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visit = new int[11];

        for(int i=0;i<n;i++)
        {
            char []arr = br.readLine().toCharArray();
            for(int j=0;j<n;j++)
            {
                if(arr[j] == 'S')
                {
                    sx =j;
                    sy = i;
                }
                else if(arr[j] == 'E')
                {
                    ex=j;
                    ey=i;
                }
                else if(arr[j] == 'U')
                    umb.add(new Entity(j, i));
            }
        }

        solution(sx,sy,h,0,0);
        if(ans == 2100000000)
            bw.write("-1");
        else
            bw.write(Integer.toString(ans));
        bw.flush();

    }
    static void solution(int x,int y, int life,int shield ,int cnt)
    {

        if(Math.abs(ex-x) + Math.abs(ey-y) <= life + shield)
        {
            ans = Math.min(ans,cnt + Math.abs(ex-x) + Math.abs(ey-y));
            return ;
        }
        for(int i=0;i<umb.size();i++) {
            int dis = Math.abs(umb.get(i).x - x) + Math.abs(umb.get(i).y - y);
            if(life + shield <= dis-1 || visit[i] ==1)
                continue;
            if(shield < dis)
            {
                visit[i] = 1;
                solution(umb.get(i).x,umb.get(i).y,life - (dis-shield),d, cnt + dis);
                visit[i] = 0;
            }
            else
            {
                visit[i] = 1;
                solution(umb.get(i).x,umb.get(i).y,life,d, cnt + dis);
                visit[i] = 0;
            }
        }

    }


}

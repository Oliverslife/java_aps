package Selected_05_GraphTraversal;

import java.io.*;
import java.util.*;

public class q18513 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> samter = new ArrayDeque<>();
//        int[] map = new int[200200002];       << 이따구로 배열에 숫자 써갈기면 당연히 메모리초과...
        boolean[] visited = new boolean[200200002];
        int tmp, left, right;
        long ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            tmp = Integer.parseInt(st.nextToken()) + 100100001;
            visited[tmp] = true;
            samter.offer(tmp);
        }

        Queue<Integer> q = new ArrayDeque<>();
        while(!samter.isEmpty())
            q.offer(samter.poll());

        int len = 1;
        bfs:
        while(!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {

                tmp = q.poll();
                left = tmp - 1;
                right = tmp + 1;

                if(!visited[left]) {
                    visited[left] = true;
                    q.offer(left);
                    ans += len;
                    if(--k == 0)
                        break bfs;
                }

                if(!visited[right]) {
                    visited[right] = true;
                    q.offer(right);
                    ans += len;
                    if(--k == 0)
                        break bfs;
                }
            }
            len++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();


    }
}

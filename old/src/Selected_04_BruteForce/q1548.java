package Selected_04_BruteForce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1548 {
    static int n, ans;
    static int[] arr;
//    static int[] ansbox = new int[51];
//    static void dfs(int depth, int start) {
//
//        if(depth >= 3)
//            for(int i=0; i<depth - 2; i++)
//                for(int j=i+1; j<depth - 1; j++)
//                    for(int k=j+1; k<depth; k++)
//                        if(!(ansbox[i] < ansbox[j] + ansbox[k] && ansbox[j] < ansbox[i] + ansbox[k] && ansbox[k] < ansbox[i] + ansbox[j]))
//                            return;
//
//        ans = Math.max(ans, depth);
//
//        if(depth == n)
//            return;
//
//        for(int i=start; i<n; i++) {
//            ansbox[depth] = arr[i];
//            dfs(depth + 1, i + 1);
//        }
//
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        ans = 1;

        for(int first = 0; first < n-1; first++)
            for(int third = n-1; third >= 0; third--) {
                if(first + 1 == third)
                    break;
                if(arr[first] + arr[first + 1] > arr[third]) {
                    ans = Math.max(ans, third - first + 1);
                    break;
                }
            }

        if(ans == 1 && n >= 2)
            ans = 2;

//        dfs(0, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

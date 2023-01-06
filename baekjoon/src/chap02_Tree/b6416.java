package chap02_Tree;

import java.util.*;

/**
 * 루트 노드는 단 하나
 * 노드에 들어오는 간선의 수가 1개
 * 노드의 수 - 간선의 수 = 1
 */
public class b6416 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Integer> set;
        int[] treeCheck;    //들어오는 간선 확인
        int tc = 0, root, edge, a, b;
        boolean flag;

        while(true) {
            set = new HashSet<>();      //노트 수 카운트
            treeCheck = new int[1001];
            root = 0;       //루트노드 수
            tc++;           //테스트 케이스
            flag = false;   //노드로 들어오는 간선의 수가 2개 이상인 경우 확인용
            edge = 0;       //간선 수 확인용

            while(true) {
                a = sc.nextInt();
                b = sc.nextInt();

                if(a == 0 && b == 0) break;
                if(a == -1 && b == -1) {
                    sc.close();
                    return;
                }

                set.add(a);
                set.add(b);
                treeCheck[b]++;
                edge++;
            }

            if(set.isEmpty()) {
                System.out.println("Case " + tc + " is a tree.");
                continue;
            }

            for(int x : set) {
                if(treeCheck[x] == 0) root++;
                if(treeCheck[x] > 1) {
                    flag = true;
                    break;
                }
            }

            if(flag || root != 1 || set.size() - edge != 1)
                System.out.println("Case " + tc + " is not a tree.");
            else
                System.out.println("Case " + tc + " is a tree.");
        }

    }
}

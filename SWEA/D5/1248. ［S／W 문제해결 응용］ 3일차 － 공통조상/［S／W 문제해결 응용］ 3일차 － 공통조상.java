import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    static int[][] graph;
    static int[] parents;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            // 노드의 개수
            int v = Integer.parseInt(st.nextToken());
            // 간선의 개수
            int e = Integer.parseInt(st.nextToken());
            // 공통 조상을 찾는 두개의 노드
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 현재 노드가 가르키는 자식 노드를 저장함 -> 이진 트리이므로 2개
            graph = new int[v + 1][2];
            // 현재 노드의 부모 노드를 저장함
            parents = new int[v + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                // 아무것도 가르키고 있지 않다면 저장
                if (graph[parent][0] == 0) {
                    graph[parent][0] = child;
                }
                // 가르키는 것이 있다면 두번째에 저장
                else {
                    graph[parent][1] = child;
                }
                // 자식노드의 부모를 저장해줌
                parents[child] = parent;
            }

            // 조상들을 저장 할 hashSet 저장
            int commonAncestor = searchAncestor(node1, node2);
            // 서브트리의 개수를 구해준다.
            int result = countSubTree(commonAncestor);

            sb.append("#" + tc + " " + commonAncestor + " " + result).append("\n");
        }
        System.out.println(sb);
    }

    private static int countSubTree(int node) {
        // 왼쪽 자식과 오른쪽 자식을 구해준다.
        int left = graph[node][0];
        int right = graph[node][1];

        // 현재 노드의 개수(1) + 왼쪽 자식이 있다면 개수 없다면 0 + 오른쪽 자식이 있다면 개수를 구해옴 없다면 0  
        return 1 + (left == 0 ? 0 : countSubTree(left)) + (right == 0 ? 0 : countSubTree(right));
    }

    // 공통 조상 노드를 찾는다.
    private static int searchAncestor(int node1, int node2) {
        // 공통 노드를 저장 할 hashSet
        HashSet<Integer> ancestor = new HashSet<>();
        // 첫번째 노드의 공통 조상을 전부 저장함
        int pos = node1;
        while (pos != 1) {
            ancestor.add(parents[pos]);
            pos = parents[pos];
        }
        // 두번째 노드의 조상들을 확인함
        pos = node2;
        while (pos != 1) {
            // 첫번째 노드의 조상에 포함된다면 return
            if (ancestor.contains(parents[pos])) {
                return parents[pos];
            } else {
                // 포함되지 않았다면 return;
                pos = parents[pos];
            }
        }

        return 0;
    }

}
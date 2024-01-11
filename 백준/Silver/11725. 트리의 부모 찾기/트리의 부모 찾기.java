import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] parent;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 개수를 저장
        n = Integer.parseInt(br.readLine());
        // 인접 리스트를 만들어준다.
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        // 각 부모를 저장하기 위한 배열
        parent = new int[n+1];
        for (int i = 0; i < n - 1; i++) {
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            // 연결시켜준다. 방향을 모르니까 양방향으로 저장
            list[a].add(b);
            list[b].add(a);
        }
        // dfs로 부모 배열을 채워줌
        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int index) {
        // 1로는 갈 일 없으므로 2부터 시작하여 부모노드인 index와 연결된 노드를 재귀호출하여 채워준다.
        for (int nextNode : list[index]) {
            if(parent[nextNode] == 0){
                parent[nextNode] = index;
                dfs(nextNode);
            }
        }
    }
}
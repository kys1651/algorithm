import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 노드의 개수 n
        int n = Integer.parseInt(br.readLine());
        // 노드의 개수당 연결된 노드를 즉, 간선을 세어주기 위한 배열 생성
        int[] nodes = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            // 연결된 노드의 간선의 개수를 더해줌
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a]++;
            nodes[b]++;
        }
        // 질의의 개수를 입력 받는다.
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // 질문이 단절선에 대한 질문이라면 무조건 yes
            if (t == 2) {
                sb.append("yes");
            }
            // 단절점에 대한 질문일 때 해당 노드의 간선의 개수가 1개라면(리프 노드라면) 단절점이 아니다.
            else if (nodes[k] == 1){
                sb.append("no");
            }
            // 노드의 간선의 개수가 1개 이상이라면(트리임이 보장되기에 0개 일 수 없다.) 단절점이다.
            else{
                sb.append("yes");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

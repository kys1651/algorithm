import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Init
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        // Init End

        // Input
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inDegree[to]++;
        }// Input End

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(' ');
            for (int next : graph[cur]) {
                if(--inDegree[next] == 0) pq.add(next);
            }
        }
        System.out.println(sb);
    }
}
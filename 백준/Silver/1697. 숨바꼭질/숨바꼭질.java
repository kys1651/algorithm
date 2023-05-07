import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int[] map;
    static boolean[] visited;
    static int n,k;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[100001];
        visited = new boolean[100001];
        bfs(n);

        System.out.println(answer);
    }

    private static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        int index = start;

        map[index] = 1;
        while (!q.isEmpty()) {
            int pos = q.poll();

            if(pos == k) answer = map[pos]-1;
            if(pos-1>= 0 && map[pos-1] == 0){
                map[pos-1] = map[pos] + 1;
                q.add(pos - 1);
            }
            if(pos+1 <= 100000 && map[pos+1] ==0){
                map[pos+1] = map[pos] + 1;
                q.add(pos + 1);
            }
            if( 2 * pos <= 100000 && map[pos*2] == 0){
                map[pos * 2] = map[pos] + 1;
                q.add(pos * 2);
            }
        }
    }
}
import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[] map;
    static int G,F,S;
    static int[] dir = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        map = new int[F + 1];
        bfs(S);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        map[start] = 1;

        while (!q.isEmpty()) {
            int n = q.poll();

            if(n == G){
                System.out.println(map[n]-1);
                return;
            }

            for(int i = 0; i < 2; i++){
                int next = n + dir[i];

                if(next > F || next < 1) continue;

                if(map[next]==0){
                    q.offer(next);
                    map[next] = map[n] + 1;
                }
            }
        }

        System.out.println("use the stairs");
    }

}



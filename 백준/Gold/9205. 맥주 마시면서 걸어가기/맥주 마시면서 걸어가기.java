import java.awt.*;
import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N,startx,starty,endx,endy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            LinkedList<int[]> list = new LinkedList<>();
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(i == 0){
                    startx = x;
                    starty = y;
                }else if(i == N+1){
                    endx = x;
                    endy= y;
                }else{
                    list.add(new int[]{x, y});
                }
            }

            if(bfs(list)){
                sb.append("happy").append("\n");
            }else{
                sb.append("sad").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean bfs(LinkedList<int[]> list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(new int[]{startx, starty});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];

            // 1000미터 이하면 그대로 편의점 안들리고 가면 됨
            if (Math.abs(px - endx) + Math.abs(py - endy) <= 1000) {
                return true;
            }


            for (int i = 0; i < N; i++) {
                if(visited[i])
                    continue;

                // 편의점 거리
                int nx = list.get(i)[0];
                int ny = list.get(i)[1];


                int distance = Math.abs(px - nx) + Math.abs(py - ny);
                if(distance <= 1000){
                    visited[i] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}

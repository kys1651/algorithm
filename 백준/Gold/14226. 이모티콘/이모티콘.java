import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Num{
        int idx;
        int clipBoard;
        int count;

        public Num(int idx, int clipBoard, int count) {
            this.idx = idx;
            this.clipBoard = clipBoard;
            this.count = count;
        }
    }


    static int S;
    static boolean[][] visited = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());

        bfs();
    }

    private static void bfs() {
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(1, 0, 0));
        visited[1][0] = true;
        // 화면 이모티콘 1, 클립보드 이모티콘 0
        while (!q.isEmpty()) {
            Num n = q.poll();

            if(n.idx == S){
                System.out.println(n.count);
                return;
            }


            // 1. 화면에 있는 이모티콘을 클립보드에 저장한다.
            if (n.idx != n.clipBoard) {
                q.add(new Num(n.idx, n.idx, n.count + 1));
            }

            // 2. 클립보드에 있는 걸 복사 붙여넣기 함
            if (n.clipBoard != 0 && n.idx + n.clipBoard < 1001 && !visited[n.idx + n.clipBoard][n.clipBoard]) {
                q.add(new Num(n.idx + n.clipBoard, n.clipBoard, n.count + 1));
                visited[n.idx + n.clipBoard][n.clipBoard] = true;
            }

            // 3. 화면에 있는 이모티콘에서 하나 지움
            if(2 <= n.idx && !visited[n.idx-1][n.clipBoard]){
                q.add(new Num(n.idx - 1, n.clipBoard, n.count + 1));
                visited[n.idx - 1][n.clipBoard] = true;
            }

        }
    }
}

import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int a, b;
    static int cheeseCount;

    // 상하좌우
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[a][b];
        // 치즈 입력 받기
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        // 치즈 제거 후 횟수 세기
        while (cheeseCheck()) {
            time++;
            visited = new boolean[a][b];
            cheeseCount = 0;
            dfs(0, 0);
        }
        System.out.println(time);
        System.out.println(cheeseCount);

    }

    // 치즈가 있는지 없는지 체크함
    private static boolean cheeseCheck() {
        // 판 위에 치즈를 전부 제거
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;

    }

    private static void dfs(int row, int col) {
        // 0,0부터 시작함 0,0은 무조건 공기임

        for (int i = 0; i < 4; i++) {
            int nextX = row + dirX[i];
            int nextY = col + dirY[i];


            // 유효하지않거나 방문했다면 넘어가기
            if (!isValid(nextX, nextY) || visited[nextX][nextY]) {
                continue;
            }
            
            visited[nextX][nextY] = true;
            if (map[nextX][nextY] == 1) {
                map[nextX][nextY] = 2;
                cheeseCount++;
            }
            else{// 공기라면
                dfs(nextX, nextY);
            }
        }
    }

    private static boolean isValid(int row, int col) {

        return row >= 0 && row < a && col >= 0 && col < b;
    }
}

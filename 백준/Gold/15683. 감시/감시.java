import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class CCTV {
        int x;
        int y;
        int num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int N, M, K, result, maxRemove;
    static int[][] map, copyMap;
    static int[] permutation;

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    static ArrayList<CCTV> cctvList = new ArrayList<>();
    static ArrayList<CCTV> num5CCTV = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    result++;
                } else if (map[i][j] != 6) {
                    CCTV cctv = new CCTV(i, j, map[i][j]);
                    if (map[i][j] == 5) {
                        num5CCTV.add(cctv);
                    } else {
                        Main.cctvList.add(cctv);
                    }
                }
            }
        }

        // 5번 먼저 처리해줌
        for (CCTV cctv : num5CCTV) {
            for (int i = 0; i < 4; i++) {
                result -= removeSpace(cctv.x, cctv.y, i);
            }
        }

        K = cctvList.size();
        permutation = new int[K];

        combination(0);

        System.out.println(result - maxRemove);
    }

    private static void combination(int depth) {
        if (depth == K) {
            // 원본 복사
            getCopyMap();

            // 시뮬레이션 실행
            goSimulation();

            // 복구
            map = copyMap;
            return;
        }

        for (int i = 0; i < 4; i++) {
            permutation[depth] = i;
            combination(depth + 1);
        }
    }


    private static void getCopyMap() {
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(map[i], M);
        }
    }

    private static void goSimulation() {
        // 지운 횟수
        int count = 0;
        for (int i = 0; i < K; i++) {
            int d = permutation[i];
            CCTV cctv = cctvList.get(i);

            // 현재 바라보는 방향은 무조건 지워주면 된다.(1번 처리)
            count += removeSpace(cctv.x, cctv.y, d);
            // 2번이면 바라보는 방향 대칭 지우기
            if (cctv.num == 2) {
                count += removeSpace(cctv.x, cctv.y, (d + 2) % 4);
            }
            // 3번이면 바라보는 방향과 그 다음 시계 방향 지우기
            else if (cctv.num == 3) {
                count += removeSpace(cctv.x, cctv.y, (d + 1) % 4);
            }
            // 4번이면 현재 바라보는 방향포함하여 4군데 지우기
            else if (cctv.num == 4) {
                count += removeSpace(cctv.x, cctv.y, (d + 1) % 4);
                count += removeSpace(cctv.x, cctv.y, (d + 2) % 4);
            }
        }

        // 전부 지운 뒤 최대로 지운 횟수 갱신
        if (maxRemove < count) maxRemove = count;
    }

    // 현재 바라보는 방향을 지워줌
    private static int removeSpace(int x, int y, int d) {
        int count = 0;
        while (isIn(x, y) && map[x][y] != 6) {
            if (map[x][y] == 0) {
                count++;
                map[x][y] = -1;
            }
            x = x + dirX[d];
            y = y + dirY[d];
        }

        return count;
    }

    // 현재 범위가 배열내에 있는지 확인
    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
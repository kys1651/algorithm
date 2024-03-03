import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 공 배열
    static class Ball {
        int x;
        int y;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 상황 배열
    static class Game {
        Ball red;
        Ball blue;
        int count;

        public Game(Ball red, Ball blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }
    }

    static int N, M; // 배열의 범위
    static int result = Integer.MAX_VALUE;// 최대값
    static boolean[][][][] visit; // 방문처리를 위한 배열
    static char[][] map;

    // 상,하,좌,우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Input
        map = new char[N][M];
        visit = new boolean[N][M][N][M];
        Ball red = null;
        Ball blue = null;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'B') {
                    map[i][j] = '.';
                    blue = new Ball(i, j);
                } else if (map[i][j] == 'R') {
                    map[i][j] = '.';
                    red = new Ball(i, j);
                }
            }
        }// Input End

        bfs(new Game(red, blue, 0));

        // 최대값이 그대로면 -1출력
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void bfs(Game game) {
        Queue<Game> queue = new LinkedList<>();
        queue.offer(game);

        while (!queue.isEmpty()) {
            Game cur = queue.poll();
            Ball curRed = cur.red;
            Ball curBlue = cur.blue;

            // 최대값보다 크다면 갱신 할 필요 X
            if (cur.count + 1 >= result) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                // 공을 놓는다.
                map[curRed.x][curRed.y] = 'R';
                map[curBlue.x][curBlue.y] = 'B';

                int nRX = curRed.x;
                int nRY = curRed.y;
                int nBX = curBlue.x;
                int nBY = curBlue.y;
                boolean redGoal = false;
                boolean blueGoal = false;

                while (true) {
                    // 변화체크
                    boolean change = false;

                    // 빨간공 진행
                    if (!redGoal) {
                        char nextRed = map[nRX + dirX[i]][nRY + dirY[i]];

                        // 갈 수 있다면 간다.
                        if (nextRed == '.') {
                            change = true;
                            map[nRX + dirX[i]][nRY + dirY[i]] = 'R';
                            map[nRX][nRY] = '.';
                            nRX += dirX[i];
                            nRY += dirY[i];
                        } else if (nextRed == 'O') {
                            map[nRX][nRY] = '.';
                            redGoal = true;
                            change = true;
                        }
                    }

                    // 파랑 공 진행
                    if (!blueGoal) {
                        char nextBlue = map[nBX + dirX[i]][nBY + dirY[i]];
                        if (nextBlue == '.') {
                            change = true;
                            map[nBX + dirX[i]][nBY + dirY[i]] = 'B';
                            map[nBX][nBY] = '.';
                            nBX += dirX[i];
                            nBY += dirY[i];
                        }
                        // 파란공이 들어간다면 더 이상 진행 X
                        else if (nextBlue == 'O') {
                            map[nBX][nBY] = '.';
                            blueGoal = true;
                            break;
                        }
                    }

                    if (!change) break;
                }

                // 놓은 공 지워줌
                map[nRX][nRY] = '.';
                map[nBX][nBY] = '.';

                // 파랑공이 들어갔다면 넘어간다.
                if (blueGoal) {
                    continue;
                }

                // 공이 들어갔다면 최소값 갱신
                if (redGoal) {
                    if (result > cur.count + 1) {
                        result = cur.count + 1;
                    }
                    continue;
                }


                // 움직인 적 없다면 넘어간다.
                if (nRX == curRed.x && nRY == curRed.y && nBX == curBlue.x && nBY == curBlue.y) {
                    continue;
                }
                // 방문한 적 있다면 넘어간다.
                if (visit[nRX][nRY][nBX][nBY]) {
                    continue;
                }
                // 방문 처리 및 큐 삽입
                visit[nRX][nRY][nBX][nBY] = true;
                queue.offer(new Game(new Ball(nRX, nRY), new Ball(nBX, nBY), cur.count + 1));
            }
        }
    }
}

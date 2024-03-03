import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Ball {
        int x;
        int y;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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

    static int result = 11;
    static char[][] map;

    // 상,하,좌,우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        map = new char[N][M];
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
        System.out.println(result == 11 ? -1 : result);
    }

    private static void bfs(Game game) {
        Queue<Game> queue = new LinkedList<>();
        queue.offer(game);

        while (!queue.isEmpty()) {
            Game cur = queue.poll();
            Ball curRed = cur.red;
            Ball curBlue = cur.blue;
            if (cur.count > 9) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                map[curRed.x][curRed.y] = 'R';
                map[curBlue.x][curBlue.y] = 'B';
                int nRX = curRed.x;
                int nRY = curRed.y;
                int nBX = curBlue.x;
                int nBY = curBlue.y;
                boolean redGoal = false;
                boolean blueGoal = false;

                while (true) {
                    boolean change = false;

                    if (!redGoal) {
                        char nextRed = map[nRX + dirX[i]][nRY + dirY[i]];
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
                    if (!blueGoal) {
                        char nextBlue = map[nBX + dirX[i]][nBY + dirY[i]];
                        if (nextBlue == '.') {
                            change = true;
                            map[nBX + dirX[i]][nBY + dirY[i]] = 'B';
                            map[nBX][nBY] = '.';
                            nBX += dirX[i];
                            nBY += dirY[i];
                        } else if (nextBlue == 'O') {
                            map[nBX][nBY] = '.';
                            blueGoal = true;
                            break;
                        }
                    }

                    if (!change) break;
                }

                map[nRX][nRY] = '.';
                map[nBX][nBY] = '.';

                if (blueGoal) {
                    continue;
                }

                if (redGoal) {
                    result = Math.min(result, cur.count + 1);
                }


                if(nRX == curRed.x && nRY == curRed.y && nBX == curBlue.x && nBY == curBlue.y){
                    continue;
                }

                queue.offer(new Game(new Ball(nRX, nRY), new Ball(nBX, nBY), cur.count+1));
            }
        }
    }
}

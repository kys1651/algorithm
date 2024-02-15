import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int H, W;
    static char[][] map;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static int tankX, tankY, tankDir;
    static String command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] != '.' && map[i][j] != '*' && map[i][j] != '#' && map[i][j] != '-') {
                        tankX = i;
                        tankY = j;
                        tankDir = getDir(map[i][j]);
                        map[i][j] = '.';
                    }
                }
            }
            br.readLine();
            command = br.readLine();

            execute();

            map[tankX][tankY] = (tankDir == 0 ? '^' : tankDir == 1 ? 'v' : tankDir == 2 ? '<' : '>');
            sb.append('#').append(tc).append(' ');
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void execute() {
        for (char c : command.toCharArray()) {
            if (c == 'U' || c == 'D' || c == 'L' || c == 'R') {
                tankDir = getDir(c);
                go();
            } else {
                shoot();
            }
        }
    }

    private static void shoot() {
        int nX = tankX;
        int nY = tankY;
        while (isIn(nX, nY)) {
            if (map[nX][nY] == '*') {
                map[nX][nY] = '.';
                return;
            } else if (map[nX][nY] == '#') {
                return;
            }
            nX += dirX[tankDir];
            nY += dirY[tankDir];
        }
    }

    private static void go() {
        int nX = tankX + dirX[tankDir];
        int nY = tankY + dirY[tankDir];

        if (isIn(nX, nY) && map[nX][nY] == '.') {
            map[nX][nY] = map[tankX][tankY];
            map[tankX][tankY] = '.';
            tankX = nX;
            tankY = nY;
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    private static int getDir(char d) {
        if (d == '^' || d == 'U') {
            return 0;
        } else if (d == 'v' || d == 'D') {
            return 1;
        } else if (d == '<' || d == 'L') {
            return 2;
        } else {
            return 3;
        }
    }
}


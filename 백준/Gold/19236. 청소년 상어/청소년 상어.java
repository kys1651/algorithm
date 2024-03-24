import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish {
        int num;
        int dir;
        int x;
        int y;
        boolean dead;

        public Fish(int num, int dir, int x, int y, boolean dead) {
            this.num = num;
            this.dir = dir;
            this.x = x;
            this.y = y;
            this.dead = dead;
        }
    }

    static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirY = {0, -1, -1, -1, 0, 1, 1, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[4][4];
        List<Fish> fishes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                fishes.add(new Fish(a, b, i, j, false));
                map[i][j] = a;
            }
        }

        Collections.sort(fishes, (o1, o2) -> o1.num - o2.num);
        Fish f = fishes.get(map[0][0] - 1);
        int startNum = f.num;
        int startDir = f.dir;
        f.dead = true;
        map[0][0] = 0;

        solve(0, 0, startNum, startDir, map, fishes);

        System.out.println(result);
    }

    private static void solve(int x, int y, int num, int dir, int[][] map, List<Fish> fishes) {
        if (result < num) {
            result = num;
        }

        moveFish(fishes, map, x, y);

        while (true) {
            int nX = x + dirX[dir];
            int nY = y + dirY[dir];

            if (!isIn(nX, nY)) {
                break;
            }
            x = nX;
            y = nY;
            if (map[nX][nY] == 0) {
                continue;
            }
            int[][] nextMap = copyMap(map);
            List<Fish> nextFishes = copyList(fishes);

            int idx = nextMap[x][y];
            Fish f = nextFishes.get(idx - 1);
            f.dead = true;
            nextMap[f.x][f.y] = 0;

            solve(x, y, num + f.num, f.dir, nextMap, nextFishes);
        }
    }

    private static List<Fish> copyList(List<Fish> fishes) {
        List<Fish> nextFishes = new ArrayList<>();
        for (Fish f : fishes) {
            nextFishes.add(new Fish(f.num, f.dir, f.x, f.y, f.dead));
        }
        return nextFishes;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] next = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                next[i][j] = map[i][j];
            }
        }
        return next;
    }

    private static void moveFish(List<Fish> fishes, int[][] map, int x, int y) {
        for (Fish fish : fishes) {
            if (fish.dead) continue;
            for (int d = 0; d < 8; d++) {
                int nextDir = (fish.dir + d) % 8;
                int nX = fish.x + dirX[nextDir];
                int nY = fish.y + dirY[nextDir];

                // 배열 밖이여서 갈 수 없거나 상어가 있다면 넘어감
                if (!isIn(nX, nY) || (nX == x && nY == y)) {
                    continue;
                }

                // 현재 위치 미리 제거
                map[fish.x][fish.y] = 0;
                // 다음 인덱스
                int idx = map[nX][nY];
                if (idx != 0) {
                    // 다른 물고기가 존재한다면 위치 변경
                    Fish nextFish = fishes.get(idx - 1);
                    nextFish.x = fish.x;
                    nextFish.y = fish.y;
                    map[fish.x][fish.y] = nextFish.num;
                }
                fish.x = nX;
                fish.y = nY;
                map[nX][nY] = fish.num;
                fish.dir = nextDir;
                break;
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
}
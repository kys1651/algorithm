import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static char[][] map;
    // 상하좌우,왼쪽(위,아래),오른쪽(위,아래)
    static int[] dirX = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dirY = {0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            for (int i = 0; i < n; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = tmp.charAt(j);
                }
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.' && countMine(i, j, false)) {
                        result++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.')
                        result++;
                }
            }

            sb.append("#" + tc + " " + result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean countMine(int x, int y, boolean mem) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < dirX.length; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if (check(nX, nY)) {
                continue;
            }

            if(map[nX][nY] == '*'){
                count++;
            } else if (map[nX][nY] == '.') {
                queue.offer(new int[]{nX, nY});
            }
        }

        if (count == 0) {
            map[x][y] = '0';
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                countMine(cur[0], cur[1], true);
            }
            return true;
        }
        if (mem) {
            map[x][y] = (char) ('0' + count);
        }
        return false;
    }

    private static boolean check(int x, int y) {
        return x < 0 || x >= map.length || y < 0 || y >= map[x].length;
    }
}
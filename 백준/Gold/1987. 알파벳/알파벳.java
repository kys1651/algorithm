import java.io.*;
import java.util.*;

class Main {
    static HashSet<Character> set = new HashSet<>();
    static char[][] map;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static int n,m,result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        set.add(map[0][0]);
        searchRoute(0,0,1);
        System.out.println(result);
    }

    private static void searchRoute(int x, int y, int count) {
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if(isValid(nX,nY) || set.contains(map[nX][nY])){
                continue;
            }

            set.add(map[nX][nY]);
            searchRoute(nX, nY, count + 1);
            set.remove(map[nX][nY]);
        }
        result = Math.max(count,result);
    }

    private static boolean isValid(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
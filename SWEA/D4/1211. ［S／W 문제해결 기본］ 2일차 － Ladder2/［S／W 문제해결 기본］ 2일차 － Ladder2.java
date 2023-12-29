import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Solution {
    static int[][] map;
    static int distance, answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            br.readLine();
            // 사다리
            map = new int[100][100];

            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            distance = Integer.MAX_VALUE;
            answer = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[0][i] == 1) {
                    dfs(i);
                }
            }
            sb.append("#" + tc + " " + answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        int x = 0;
        int y = start;
        int count = 0;
        while (x < map.length) {
            if( y - 1 >= 0 && map[x][y-1] == 1){
                while(y - 1 >= 0 && map[x][y-1] == 1){
                    y--;
                    count++;
                }
            } else if (y + 1 < map.length && map[x][y + 1] == 1) {
                while (y + 1 < map.length && map[x][y + 1] == 1) {
                    count++;
                    y++;
                }
            }
            x++;
            count++;
        }

        if (distance >= count) {
            distance = count;
            answer = start;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0);
        System.out.println(min);
    }

    private static void solution(int depth) {
        if (depth == n) {
            cal();
            return;
        }
        visited[depth] = true;
        solution(depth + 1);
        visited[depth] = false;
        solution(depth + 1);
    }

    private static void cal() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += (map[i][j] + map[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    link += (map[i][j] + map[j][i]);
                }
            }
        }
        int tmp = Math.abs(start - link);
        if(tmp == 0){
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, tmp);
    }

}

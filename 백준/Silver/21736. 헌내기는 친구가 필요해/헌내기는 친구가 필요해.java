import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int[] start = new int[2];
        // Input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }// Input End

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int answer = 0;
        map[start[0]][start[1]] = 'X';

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] == 'X') {
                    continue;
                }

                if(map[nX][nY] == 'P'){
                    answer++;
                }
                map[nX][nY] = 'X';
                queue.add(new int[]{nX, nY});
            }
        }
        System.out.println(answer == 0 ? "TT" : answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        map = new int[a][b];
        answer = new int[a][b];
        for(int i = 0; i < a; i++){
            Arrays.fill(answer[i],-1);
        }

        int[] start = new int[2];
        for(int i = 0; i < a; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < b; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    answer[i][j] = 0;
                }
                if(map[i][j] == 2){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        bfs(start);
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        answer[start[0]][start[1]] = 0;
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (nX < 0 || nX >= answer.length || nY < 0 || nY >= answer[nX].length) {
                    continue;
                }
                if (map[nX][nY] == 1 && answer[nX][nY] == -1) {
                    answer[nX][nY] = answer[cur[0]][cur[1]] + 1;
                    queue.offer(new int[] {nX, nY});
                }
            }

        }
    }
}
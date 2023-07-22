import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static char[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 가로 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char tmp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = tmp;

                solution();

                tmp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = tmp;
            }
        }

        // 세로 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char tmp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = tmp;

                solution();

                tmp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = tmp;
            }
        }

        System.out.println(max);
    }

    private static void solution(){

        // 가로
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {

                if (map[i][j] == map[i][j + 1]) {
                    count++;
                }
                else{
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        // 세로
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {

                if (map[j][i] == map[j + 1][i]) {
                    count++;
                }else{
                    count = 1;
                }

                max = Math.max(max, count);
            }
        }
    }
}



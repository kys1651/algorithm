import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map, copyMap;
    static boolean[][] visit, union;
    static int sum, count, avg;

    // 상,하,좌,우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copyMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean exit = false;
        while (!exit) {

            // 원본 복사
            for (int i = 0; i < N; i++) {
                copyMap[i] = Arrays.copyOf(map[i], N);
            }
            visit = new boolean[N][N];
            union = new boolean[N][N];

            exit = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) continue;

                    sum = 0;
                    count = 0;
                    avg = 0;
                    getCountSum(i, j);
                    if (count == 1) {
                        continue;
                    }

                    avg = sum / count;
                    exit = false;
//                    System.out.println("answer - " + answer);
//                    System.out.println(sum);
//                    System.out.println(count);
//                    System.out.println(avg);

                    writeAvgUnion(i, j);
//                    print();
                }
            }

            answer++;
        }

        System.out.println(answer - 1);
    }

    private static void print() {
        for (int[] ts : map) {
            for (int t : ts) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void writeAvgUnion(int x, int y) {
        union[x][y] = true;
        map[x][y] = avg;

        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if (nX < 0 || nX >= N || nY < 0 || nY >= N || union[nX][nY]) {
                continue;
            }

            int gap = Math.abs(copyMap[x][y] - copyMap[nX][nY]);
            if (gap >= L && gap <= R) {
                writeAvgUnion(nX, nY);
            }
        }
    }

    private static void getCountSum(int x, int y) {
        visit[x][y] = true;
        count++;
        sum += copyMap[x][y];
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if (nX < 0 || nX >= N || nY < 0 || nY >= N || visit[nX][nY]) {
                continue;
            }

            int gap = Math.abs(copyMap[x][y] - copyMap[nX][nY]);
            if (gap >= L && gap <= R) {
                getCountSum(nX, nY);
            }
        }
    }

    private static boolean getCount() {


        boolean exit = true;


        return exit;
    }
}
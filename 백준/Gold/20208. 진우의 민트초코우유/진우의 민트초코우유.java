import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> milk = new ArrayList<>();
    static boolean[] eat;
    static int[] homeDist;
    static int N, H, milkCount, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int sX = 0, sY = 0;

        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    sX = i;
                    sY = j;
                } else if (val == 2) {
                    milk.add(new int[]{i, j});
                    milkCount++;
                }
            }
        } // Input End

        // 각 우유에서 집으로 가는 거리를 구함
        homeDist = new int[milkCount];
        for(int i = 0; i < milkCount; i++) {
            int[] m = milk.get(i);
            homeDist[i] = getDist(sX,sY,m[0],m[1]);
        }

        eat = new boolean[milkCount];
        solve(sX, sY, M, 0);
        System.out.println(result);
    }

    private static void solve(int x, int y, int move, int eatCount) {
        // 이미 최대값만큼 먹었거나 움직일 수 없다면 멈춤
        if (result == milkCount) {
            return;
        }

        for (int i = 0; i < milk.size(); i++) {
            int[] m = milk.get(i);
            int d = getDist(x, y, m[0], m[1]);
            // 갈 수 없거나 먹은 적 있다면 넘어간다.
            if (d > move || eat[i]) {
                continue;
            }
            int nextMove = move - d + H;
            if(nextMove >= homeDist[i] && eatCount + 1 > result) {
                result = eatCount + 1;
            }
            eat[i] = true;
            solve(m[0], m[1], nextMove, eatCount + 1);
            eat[i] = false;
        }
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
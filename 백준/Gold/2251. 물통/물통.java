import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    static boolean[][][] visit = new boolean[201][201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dfs(0, 0, C);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= C; i++) {
            if (visit[0][C - i][i]) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int z) {
        visit[x][y][z] = true;

        // X에서 갈 수 있는 경우 확인
        if (x != 0) {
            int nX = 0;
            int nY = y + x;
            if (nY > B) {
                nX = nY - B;
                nY = B;
            }
            if (!visit[nX][nY][z]) {
                dfs(nX, nY, z);
            }

            nX = 0;
            int nZ = z + x;
            if (nZ > C) {
                nX = nZ - C;
                nZ = C;
            }
            if (!visit[nX][y][nZ]) {
                dfs(nX, y, nZ);
            }
        }

        if (y != 0) {
            int nX = x + y;
            int nY = 0;
            if (nX > A) {
                nY = nX - A;
                nX = A;
            }
            if (!visit[nX][nY][z]) {
                dfs(nX, nY, z);
            }

            nY = 0;
            int nZ = z + y;
            if (nZ > C) {
                nY = nZ - A;
                nZ = C;
            }
            if (!visit[x][nY][nZ]) {
                dfs(nX, nY, z);
            }
        }

        if (z != 0) {
            int nX = x + z;
            int nZ = 0;
            if (nX > A) {
                nZ = nX - A;
                nX = A;
            }
            if (!visit[nX][y][nZ]) {
                dfs(nX, y, nZ);
            }

            nZ = 0;
            int nY = y + z;
            if (nY > B) {
                nZ = nY - B;
                nY = B;
            }
            if (!visit[x][nY][nZ]) {
                dfs(x, nY, nZ);
            }
        }
    }
}

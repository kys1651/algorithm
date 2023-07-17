import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int l;
        int r;
        int c;

        public Point(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    static int L,R, C;
    static int[][][] map;
    static Point Start,End;

    // 동서남북,위,아래
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
    static int[] dL = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new int[L][R][C];

            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < C; j++) {
                        char ch = line.charAt(j);

                        map[k][i][j] = 0;
                        if(ch == 'S'){
                            map[k][i][j] = 1;
                            Start = new Point(k, i, j);
                        } else if (ch == 'E') {
                            End = new Point(k, i, j);
                        } else if(ch == '#'){
                            map[k][i][j] = -1;
                        }
                    }
                }
                br.readLine();
            }

            bfs();
        }
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(Start);

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();


            for (int d = 0; d < 6; d++) {
                int nl = tmp.l + dL[d];
                int nr = tmp.r + dr[d];
                int nc = tmp.c + dc[d];

                // End 위치일 경우 출력 후 return
                if (nl == End.l && nr == End.r && nc == End.c) {
                    System.out.println("Escaped in " + map[tmp.l][tmp.r][tmp.c] +  " minute(s).");
                    return;
                }
                // 범위밖이거나 벽(-1)이거나 이미 들른 곳일(> 1) 경우 Skip
                if (!isCheck(nl, nr, nc) || map[nl][nr][nc] != 0) continue;

                map[nl][nr][nc] = map[tmp.l][tmp.r][tmp.c] + 1;
                queue.add(new Point(nl, nr, nc));
            }
        }
        // while문 탈출시 갈 수 없음
        System.out.println("Trapped!");
    }
//
//    private static void printArray() {
//        for (int[][] ma : map) {
//            System.out.println("------");
//            for (int[] m : ma) {
//                for (int num : m) {
//                    System.out.print(num);
//                }
//                System.out.println();
//            }
//            System.out.println();System.out.println();
//        }
//    }

    private static boolean isCheck(int l, int r, int c) {
        return (l >= 0 && l < L)&&(r >= 0 && r < R)&&(c >= 0 && c < C);
    }

}

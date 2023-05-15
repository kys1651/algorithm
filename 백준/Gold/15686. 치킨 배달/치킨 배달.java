import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static int N,M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];
        solution(0,0);
        System.out.println(answer);
    }

    private static void solution(int idx,int depth) {
        // 치킨집을 M개 골랐을 때 계산함
        if(depth == M){
            // 계산하는 함수
            cal();
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                solution(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    // 계신헤주는 함수
    private static void cal() {
        int result = 0;

        for (Point h : house) {
            int tmp = Integer.MAX_VALUE;

            for (int i = 0; i < chicken.size(); i++) {
                if(!visited[i]) continue;

                int distance = Math.abs(h.x - chicken.get(i).x) + Math.abs(h.y - chicken.get(i).y);
                tmp = Math.min(tmp, distance);
            }
            result += tmp;
        }

        answer = Math.min(answer, result);
    }
}

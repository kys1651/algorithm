import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int count;
        int value;

        public Point(int count, int value) {
            this.count = count;
            this.value = value;
        }
    }

    static final int LIMIT = 99999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        int answer = bfs(N, T, G);
        System.out.println(answer == -1 ? "ANG" : answer);

    }

    private static int bfs(int n, int t, int g) {
        boolean[] visited = new boolean[LIMIT + 1];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, n));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.value == g) return cur.count;
            if (cur.value + 1 <= LIMIT && !visited[cur.value + 1] && cur.count < t) {
                q.add(new Point(cur.count + 1, cur.value + 1));
                visited[cur.value + 1] = true;
            }

            if (cur.value * 2 <= LIMIT) {
                int nextValue = getValue(cur.value) ;
                if (!visited[nextValue] && cur.count < t) {
                    q.add(new Point(cur.count + 1, nextValue));
                    visited[nextValue] = true;
                }
            }
        }

        return -1;
    }

    private static int getValue(int value) {
        if (value == 0) return value;
        // * 2 하고 가장 큰 자리수를 가져와야한다.
        char[] chars = String.valueOf(value * 2).toCharArray();
        int ret = 0;
        int unit = 1;
        for (int i = chars.length - 1; i >= 1; i--) {
            ret += (chars[i] - '0') * unit;
            unit *= 10;
        }

        ret += unit * (chars[0] - '0' - 1);
        return ret;
    }
}
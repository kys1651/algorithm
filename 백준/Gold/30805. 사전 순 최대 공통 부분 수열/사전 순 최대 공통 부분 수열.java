import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point> {
        int value;
        int idx;

        public Point(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point o) {
            if (value != o.value) return value - o.value;
            return o.idx - this.idx;
        }
    }

    static int la, ra, lb, rb, size;
    static int[] answer = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        ra = Integer.parseInt(br.readLine());
        int[] a = new int[ra];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ra; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        rb = Integer.parseInt(br.readLine());
        int[] b = new int[rb];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rb; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }// Input End

        while (la != ra && lb != rb) {
            if (!getCommon(getList(la, ra, a), getList(lb, rb, b))) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(size).append('\n');
        for(int i = 0; i < size; i++) sb.append(answer[i]).append(' ');
        System.out.println(sb);
    }

    private static boolean getCommon(Point[] a, Point[] b) {
        int aIdx = a.length - 1, bIdx = b.length - 1;
        while (aIdx >= 0 && bIdx >= 0) {
            Point pA = a[aIdx];
            Point pB = b[bIdx];
            if (pA.value == pB.value) {
                la = pA.idx + 1;
                lb = pB.idx + 1;
                answer[size++] = pB.value;
                return true;
            } else if (pA.value > pB.value) {
                aIdx--;
            } else {
                bIdx--;
            }
        }
        return false;
    }

    private static Point[] getList(int l, int r, int[] arr) {
        Point[] points = new Point[r - l];
        for (int i = l; i < r; i++) {
            points[i - l] = new Point(arr[i], i);
        }
        Arrays.sort(points);
        return points;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Top {
        int idx;
        int height;

        public Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Top[] tops = new Top[N + 1];
        long[] left = new long[N + 1];
        long[] right = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tops[i] = new Top(i, Integer.parseInt(st.nextToken()));
        }

        Stack<Top> leftTop = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!leftTop.isEmpty() && leftTop.peek().height < tops[i].height) {
                leftTop.pop();
            }
            if (!leftTop.isEmpty()) {
                left[i] = left[leftTop.peek().idx] + getDistance(leftTop.peek(), tops[i]);
            }
            leftTop.add(tops[i]);
        }

        Stack<Top> rightTop = new Stack<>();
        for (int i = N; i >= 1; i--) {
            while(!rightTop.isEmpty() && rightTop.peek().height < tops[i].height){
                rightTop.pop();
            }
            if(!rightTop.isEmpty()){
                right[i] = right[rightTop.peek().idx] + getDistance(tops[i], rightTop.peek());
            }
            rightTop.push(tops[i]);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            int p = Integer.parseInt(br.readLine());
            sb.append(left[p] + right[p]).append('\n');
        }
        System.out.println(sb);
    }

    private static long getDistance(Top a, Top b) {
        long x = a.idx - b.idx;
        long y = a.height - b.height;
        return x * x + y * y;
    }
}


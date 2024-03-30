import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static class Wire implements Comparable<Wire>{
        int from;
        int to;
        int dp;

        public Wire(int from, int to, int dp) {
            this.from = from;
            this.to = to;
            this.dp = dp;
        }

        @Override
        public int compareTo(Wire o) {
            return from - o.from;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 전기줄의 인덱스, 출발점과 도착점 디피 수
        Wire[] wires = new Wire[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int count = 0;
            wires[i] = new Wire(from, to, count);
        }
        Arrays.sort(wires);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            Wire w = wires[i];
            for (int j = 0; j < i; j++) {
                if (w.to > wires[j].to && count < wires[j].dp) {
                    count = wires[j].dp;
                }
            }
            w.dp = count + 1;
            answer = Math.max(w.dp, answer);
        }
        System.out.println(N - answer);
    }
}

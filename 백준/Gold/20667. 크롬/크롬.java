import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Tap {
        int cpu;
        int memory;
        int priority;

        public Tap(int cpu, int memory, int priority) {
            this.cpu = cpu;
            this.memory = memory;
            this.priority = priority;
        }
    }

    static final int MIN = -987654321;
    static int n, m, k, p;
    static int[][][] dp;
    static Tap[] tabList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 개수
        m = Integer.parseInt(st.nextToken()); // CPU
        k = Integer.parseInt(st.nextToken()); // MEM
        p = n * 5;

        dp = new int[n][m + 1][p + 1];
        for (int[][] d : dp) {
            for (int[] p : d) {
                Arrays.fill(p, -1);
            }
        }

        tabList = new Tap[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cpu = Integer.parseInt(st.nextToken());
            int mem = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tabList[i] = new Tap(cpu, mem, p);
        }
        printResult();
    }

    private static void printResult() {
        for (int i = 0; i <= p; i++) {
            int result = solve(0, 0, i);
            if (result >= k) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    static int solve(int cur, int cpu, int p) {
        if (cur == n) return cpu >= m ? 0 : MIN;
        if (dp[cur][cpu][p] != -1) return dp[cur][cpu][p];
        int nextCpu = Math.min(cpu + tabList[cur].cpu, m);
        int a = solve(cur + 1, cpu, p);
        int b = p - tabList[cur].priority >= 0 ? // 다음 탭을 확인할 수 있는 중요도라면
                solve(cur + 1, nextCpu, p - tabList[cur].priority) + tabList[cur].memory : // 확인
                MIN; // 아니라면 안되는 값
        return dp[cur][cpu][p] = Math.max(a, b);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n, k, min, count;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n >= k) {
            System.out.println(n - k + "\n" + 1);
            return;
        }
        bfs();
        System.out.println(min + "\n" + count);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        arr[n] = 1;
        count = 0;
        min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 방문 시간이 최소 시간보다 크면 체크 할 필요 x
            if (arr[cur] > min)
                continue;

            int[] next = {cur - 1, cur + 1, cur * 2};
            for (int i = 0; i < 3; i++) {
                if (next[i] < 0 || next[i] > 100000)
                    continue;

                // 동생이 있는 곳을 발견
                if (next[i] == k) {
                    min = arr[cur];
                    count++;
                }

                // 첫방문이거나 방문한 곳에 같은 시간으로 방문했다면 Queue에 넣기
                if (arr[next[i]] == 0 || arr[next[i]] == arr[cur] + 1) {
                    queue.offer(next[i]);
                    arr[next[i]] = arr[cur] + 1;
                }
            }

        }
    }
}

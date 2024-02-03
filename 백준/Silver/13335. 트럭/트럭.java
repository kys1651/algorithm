import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> bridge = new LinkedList<>();
        int time = 0, weight = 0,idx = 0;
        while (!bridge.isEmpty() || idx != N) {
            // 현재 다리에 있는 트럭이 나와야 할 시간이라면 빼준다.
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                weight -= bridge.remove()[0];
            }
            // 다리의 트럭의 개수가 L보다 작고 트럭을 추가해도 된다면 올려준다.
            if (bridge.size() < W && idx != N && trucks[idx] + weight <= L) {
                // 트럭을 빼준다.
                // 현재 가중치에 더해준다.
                weight += trucks[idx];
                // 다리에 현재 시간을 기록해서 올려준다.
                bridge.add(new int[]{trucks[idx], time + W});
                idx++;
            }
            time++;
        }
        System.out.println(time);
    }
}

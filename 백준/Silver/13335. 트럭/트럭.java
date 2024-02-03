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

        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> bridge = new LinkedList<>();
        int time = 0, weight = 0;
        while (!bridge.isEmpty() || !trucks.isEmpty()) {
            // 현재 다리에 있는 트럭이 나와야 할 시간이라면 빼준다.
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                weight -= bridge.remove()[0];
            }
            // 다리의 트럭의 개수가 L보다 작고 트럭을 추가해도 된다면 올려준다.
            if (bridge.size() < W && !trucks.isEmpty() && trucks.peek() + weight <= L) {
                // 트럭을 빼준다.
                int truck = trucks.remove();
                // 현재 가중치에 더해준다.
                weight += truck;
                // 다리에 현재 시간을 기록해서 올려준다.
                bridge.add(new int[]{truck, time + W});
            }
            time++;
        }
        System.out.println(time);
    }
}

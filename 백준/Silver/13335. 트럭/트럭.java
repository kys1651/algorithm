import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static class Truck {
        int weight;
        int outTime;

        public Truck(int weight, int outTime) {
            this.weight = weight;
            this.outTime = outTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Truck[] trucks = new Truck[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = new Truck(Integer.parseInt(st.nextToken()), W);
        }

        Queue<Truck> bridge = new LinkedList<>();
        // 가장 첫번째 트럭을 넣어줌
        bridge.add(trucks[0]);
        int time = 1, weight = trucks[0].weight, idx = 1, count = 1;
        while (idx != N) {
            // 다리에 있는 트럭이 나올 시간이라면 빼준다.
            if (bridge.peek().outTime == time) {
                weight -= bridge.remove().weight;
                count--;
            }
            // 다리의 트럭의 개수가 W보다 작고 추가해도 될 무게라면 올려준다.
            if (count < W && idx != N && trucks[idx].weight + weight <= L) {
                // 트럭을 빼준다.
                Truck truck = trucks[idx++];
                // 현재 가중치에 더해준다.
                weight += truck.weight;
                // 다리에 현재 시간을 기록해서 올려준다.
                truck.outTime += time;
                bridge.add(truck);
                count++;
            }
            time++;
        }

        while (!bridge.isEmpty()) {
            time = bridge.poll().outTime;
        }
        System.out.println(time + 1);
    }
}

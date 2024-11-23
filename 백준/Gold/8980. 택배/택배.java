import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Delivery implements Comparable<Delivery> {
    int start;
    int end;
    int boxNum;

    Delivery(int start, int end, int boxNum) {
        this.start = start;
        this.end = end;
        this.boxNum = boxNum;
    }

    @Override
    public int compareTo(Delivery o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 마을의 수
        int c = Integer.parseInt(st.nextToken()); // 트럭 용량

        int m = Integer.parseInt(br.readLine()); // 박스 정보 개수
        Delivery[] deliveries = new Delivery[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int boxNum = Integer.parseInt(st.nextToken());
            deliveries[i] = new Delivery(start, end, boxNum);
        }

        // 도착 마을 기준 정렬
        Arrays.sort(deliveries);

        int[] weight = new int[n + 1]; // 각 경유지의 남은 용량 추적
        Arrays.fill(weight, c);

        int result = 0;
        for (Delivery d : deliveries) {
            int maxBoxNum = Integer.MAX_VALUE;

            // 경유지 용량 확인
            for (int i = d.start; i < d.end; i++) {
                maxBoxNum = Math.min(maxBoxNum, weight[i]);
            }

            // 실제 운반할 박스 수
            int sendBox = Math.min(maxBoxNum, d.boxNum);

            // 경유지 용량 업데이트
            for (int i = d.start; i < d.end; i++) {
                weight[i] -= sendBox;
            }

            result += sendBox;
        }

        System.out.println(result);
    }
}

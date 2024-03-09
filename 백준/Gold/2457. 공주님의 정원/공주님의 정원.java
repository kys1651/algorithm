import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Flower implements Comparable<Flower> {
        int sMon;
        int sDay;
        int sDays;
        int eMon;
        int eDay;
        int eDays;

        public Flower(int sMon, int sDay, int eMon, int eDay) {
            this.sMon = sMon;
            this.sDay = sDay;
            this.sDays = parseDay(sMon, sDay);
            this.eMon = eMon;
            this.eDay = eDay;
            this.eDays = parseDay(eMon, eDay);
        }

        @Override
        public int compareTo(Flower o) {
            return sDays - o.sDays;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Flower{");
            sb.append("시작 월=").append(sMon);
            sb.append("\n시작 일=").append(sDay);
            sb.append("\n총일 수=").append(sDays);
            sb.append("\n종료 월=").append(eMon);
            sb.append("\n종료 일=").append(eDay);
            sb.append("\n총일 수=").append(eDays);
            sb.append('}');
            return sb.toString();
        }
    }

    static int[] monDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

    static final int START = parseDay(3, 1);
    static final int END = parseDay(11, 30);


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Flower> prevFlower = new PriorityQueue<>();
        PriorityQueue<Flower> ingFlower = new PriorityQueue<>((o1, o2) -> o2.eDays - o1.eDays);
        // Input
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sMon = Integer.parseInt(st.nextToken());
            int sDay = Integer.parseInt(st.nextToken());
            int eMon = Integer.parseInt(st.nextToken());
            int eDay = Integer.parseInt(st.nextToken());
            prevFlower.add(new Flower(sMon, sDay, eMon, eDay));
        }// Input End

        // 첫번째 꽃을 얻음
        Flower cur = prevFlower.poll();
        while (!prevFlower.isEmpty() && prevFlower.peek().sDays <= START) {
            Flower f = prevFlower.poll();
            if (f.eDays >= cur.eDays) {
                cur = f;
            }
        }

        if (cur.sDays > START) {
            System.out.println(0);
            return;
        }
        int count = 1;
        while (cur.eDays - 1 < END) {
            // 필 수 있는 꽃 전부 빼주기
            while (!prevFlower.isEmpty() && prevFlower.peek().sDays <= cur.eDays) {
                Flower f = prevFlower.poll();
                if (f.eDays >= cur.sDays) {
                    ingFlower.add(f);
                }
            }

            while (!ingFlower.isEmpty() && ingFlower.peek().eDays < cur.sDays) {
                ingFlower.poll();
            }

            if (ingFlower.isEmpty()) {
                count = 0;
                break;
            }
            cur = ingFlower.poll();
            count++;
        }
        System.out.println(count);
    }

    private static int parseDay(int mon, int day) {
        int rt = 0;
        for (int i = 1; i < mon; i++) {
            rt += monDay[i];
        }
        return rt + day;
    }
}

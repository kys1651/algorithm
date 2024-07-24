import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Lecture {
        int value;
        int time;

        public Lecture(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>((o1, o2) -> o1.time == o2.time ? o2.value - o1.value : o1.time - o2.time);
        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(v, t));
        }// Input End

        PriorityQueue<Lecture> ing = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
            if (ing.size() < lecture.time) {
                ing.add(lecture);
            } else if (ing.size() == lecture.time && ing.peek().value < lecture.value) {
                ing.poll();
                ing.add(lecture);
            }
        }

        int answer = 0;
        while (!ing.isEmpty()) {
            Lecture lecture = ing.poll();
            answer += lecture.value;
//            System.out.println(lecture.time + " " + lecture.value);
        }
        System.out.println(answer);
    }
}
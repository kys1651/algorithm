import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Time> prev = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        PriorityQueue<Time> ing = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        // Input
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            prev.add(new Time(start, end));
        }// Input End

        ing.add(prev.poll());
        while (!prev.isEmpty()) {
            Time t = prev.poll();
            if (ing.peek().end <= t.start) ing.poll();
            ing.add(t);
        }
        System.out.println(ing.size());
    }
}
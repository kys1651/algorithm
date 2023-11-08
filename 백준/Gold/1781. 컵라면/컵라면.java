import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> problems =
                new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            problems.offer(new int[] {sc.nextInt(), sc.nextInt()});
        }
        while (!problems.isEmpty()) {
            int[] problem = problems.poll();
            pq.offer(problem);
            if (problem[0] < pq.size()) {
                int[] t = pq.poll();
            }
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll()[1];
        }
        System.out.println(sum);
    }
}

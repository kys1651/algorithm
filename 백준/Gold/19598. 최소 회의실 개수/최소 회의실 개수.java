import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // Input
        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] =  Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }// Input End
        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> ing = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        ing.add(time[0]);
        for(int i = 1;i < N; i++) {
            if (ing.peek()[1] <= time[i][0]) ing.poll();
            ing.add(time[i]);
        }
        System.out.println(ing.size());
    }
}
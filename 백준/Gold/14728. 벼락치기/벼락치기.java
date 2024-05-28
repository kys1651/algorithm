import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] score = new int[T + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            for (int j = T - K; j >= 0; j--) {
                if (score[j + K] < score[j] + S) {
                    score[j + K] = score[j] + S;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= T; i++) {
            if (score[i] > answer) {
                answer = score[i];
            }
        }
        System.out.println(answer);
    }
}
import java.io.*;
import java.util.*;

class Main {
    static final int BLACK = 0, WHITE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] road = new int[N];
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            road[i] = input.charAt(i) == 'B' ? BLACK : WHITE;
        }

        int[] count = new int[2];
        int left = 0, right = 1;
        int answer = 0;
        count[road[0]]++;
        if (isValid(count, B, W)) answer = 1;
        while (right < N) {
            if (count[BLACK] <= B) {
                count[road[right++]]++;
            } else {
                count[road[left++]]--;
            }
            if (isValid(count, B, W)) answer = Math.max(right - left, answer);
        }

        System.out.println(answer);
    }

    private static boolean isValid(int[] count, int B, int W) {
        return count[0] <= B && count[1] >= W;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] count = new int[100001];
        int left = 0, right = 0;
        int answer = 0;

        // Input
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }// Input End

        while (right < N) {
            while (left < right && count[arr[right]] >= K) {
                count[arr[left++]]--;
            }
            count[arr[right++]]++;
            answer = Math.max(answer, right - left);
        }

        System.out.println(answer);
    }
}
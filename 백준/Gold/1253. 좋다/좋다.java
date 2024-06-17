import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }// Input End
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (check(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(int idx) {
        int l = 0, r = N - 1;
        int checkNum = arr[idx];
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (l == idx || sum < checkNum) {
                l++;
            } else if (r == idx || sum > checkNum) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }
}
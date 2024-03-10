import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            for (int j = i; j >= 0; j--) {
                set.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);

        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                int searchValue = arr[i] - arr[j];
                if (set.contains(searchValue)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}

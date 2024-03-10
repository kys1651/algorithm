import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // Input End
        ArrayList<Integer> two = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                two.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(two);

        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                int searchValue = arr[i] - arr[j];
                if (search(searchValue, two)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    private static boolean search(int value, ArrayList<Integer> arr) {
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if(arr.get(mid) == value) return true;
            else if (arr.get(mid) > value) end = mid;
            else start = mid + 1;
        }
        return false;
    }
}

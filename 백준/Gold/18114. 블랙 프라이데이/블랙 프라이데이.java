import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] items = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            items[i] = value;
            if (value == C) {
                System.out.println(1);
                return;
            }
        }
        Arrays.sort(items);
        System.out.println(isValidWeight(items, 0, N - 1, C) ? 1 : 0);
    }

    private static boolean isValidWeight(int[] items, int l, int r, int goal) {
        while (l < r) {
            int sum = items[l] + items[r];
            if (sum > goal) {
                r--;
            } else if (sum == goal) {
                return true;
            } else {
                int rest = goal - sum;
                if (binarySearch(l + 1, r - 1, rest, items)) return true;
                l++;
            }
        }
        return false;
    }

    private static boolean binarySearch(int l, int r, int key, int[] items) {
        while (l <= r) {
            int mid = (r + l) >> 1;
            if (items[mid] == key) {
                return true;
            } else if (items[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
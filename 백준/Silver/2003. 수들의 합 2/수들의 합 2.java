import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, sum = 0, count = 0;
        while (s < n) {
            if (sum > m || e == n) {
                sum -= nums[s++];
            } else {
                sum += nums[e++];
            }
            if (sum == m) {
                count++;
            }
        }
        System.out.println(count);
    }
}

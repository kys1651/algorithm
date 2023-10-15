import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            Stack<Integer> stack = new Stack<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            int max = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > max)
                    max = arr[i];
                result += max - arr[i];
            }

            bw.write("#" + testCase + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int max = 0;
            while (st.hasMoreTokens()) {
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }
            bw.write("#" + testCase + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }
}

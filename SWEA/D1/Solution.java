import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            double result = 0;
            int size = st.countTokens();
            while (st.hasMoreTokens()) {
                result += Integer.parseInt(st.nextToken());
            }
            result /= size;
            bw.write("#" + test_case + " " + (int) Math.round(result) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

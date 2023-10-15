import java.io.*;
import java.util.*;

class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);
            int origin = num.length();
            int remove = num.replaceAll("[369]", "").length();
            int diff = origin - remove;

            if (diff == 0) {
                sb.append(num);
            } else {
                while (diff-- > 0) {
                    sb.append("-");
                }
            }
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char[] chars = "+++++".toCharArray();
            chars[i] = '#';
            sb.append(chars).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

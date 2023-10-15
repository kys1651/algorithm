import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int result = 0;

        for (char ch : line.toCharArray()) {
            result += (ch - '0');
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}

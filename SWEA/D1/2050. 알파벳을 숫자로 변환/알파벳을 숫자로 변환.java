import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        for (char ch : line.toCharArray()) {
            int tmp = ch - 'A' + 1;
            bw.write(tmp + " ");
        }
        bw.flush();
        bw.close();
    }
}

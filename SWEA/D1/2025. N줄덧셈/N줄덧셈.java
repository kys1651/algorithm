import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = factorial(N);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int factorial(int n) {
        if (n == 1)
            return 1;
        return factorial(n - 1) + n;
    }
}

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        String[] grade = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
			double[] scores = new double[N];
            for (int i = 0; i < N; i++) {
                int m = sc.nextInt();
                int f = sc.nextInt();
                int h = sc.nextInt();
                scores[i] = m * 0.35 + f * 0.45 + h * 0.2;
            }
            
            double standard = scores[K-1];
            Arrays.sort(scores);
            for(int i = 0; i < N; i++){
                if(scores[i] == standard){
                    System.out.printf("#%d %s\n",tc,grade[i / (N / 10)]);
                    break;
                }
            }

        }
    }
}

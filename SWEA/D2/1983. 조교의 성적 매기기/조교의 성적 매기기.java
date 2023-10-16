import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
			double[] scores = new double[N + 1];
            
            for (int i = 1; i <= N; i++) {
                int m = sc.nextInt();
                int f = sc.nextInt();
                int h = sc.nextInt();
                double score = cal(m, f, h);
                scores[i] = score;
            }
            double standard = scores[K];
            Arrays.sort(scores);
            int idx = 1;
            int unit = 0;
            for(int i = N; i >= 1; i--){
                if(scores[i] > standard){
                    idx++;
                    if(idx > N/10){
                    	idx = 1;
                        unit++;
                    }
                }
                else if(scores[i] == standard){
                    System.out.printf("#%d %s\n",tc,grade[unit]);
                    break;
                }
            }

        }
    }
    static double cal(int m, int f, int h){
        return m * 0.35 + f * 0.45 + h * 0.2;
    }
}

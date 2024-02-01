import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];
            for(int i =0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n ;j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for(int i = 0 ; i < n - m + 1; i++){
                for(int j = 0; j < n - m + 1; j++){
                    int tmp = 0;
                    for(int x = 0; x < m; x++){
                        for(int y = 0 ; y < m; y++){
                            tmp += board[i + x][j + y];
                        }
                    }
                    max = Math.max(max,tmp);
                }
            }
            sb.append(String.format("#%d %d\n",tc,max));
        }
        System.out.println(sb);
    }
}
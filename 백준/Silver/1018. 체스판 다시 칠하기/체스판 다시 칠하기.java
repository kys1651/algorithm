import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static boolean arr[][];
    public static int answer = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];


        for(int i = 0 ; i  < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j) == 'W' ? true : false;
            }
        }

        for(int i = 0 ; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(answer);
    }

    public static void find(int x, int y){
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for(int i = x; i < end_x; i++){
            for(int j = y; j < end_y; j++){
                if(arr[i][j] != TF) {
                    count++;
                }

                TF = !TF;
            }
            TF = !TF;
        }

        count = Math.min(count, 64 - count);
        answer = Math.min(count, answer);
    }
}
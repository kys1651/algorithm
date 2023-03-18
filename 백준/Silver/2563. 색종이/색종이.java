import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[100][100];
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int x = a; x < a + 10; x++) {
                for (int y = b; y < b + 10; y++) {
                    arr[x][y]++;
                }
            }
        }

        int count = 0 ;
        for(int i = 0; i < 100; i++){
            for(int j = 0 ; j < 100; j++){
                if(arr[i][j] > 1){
                    count += arr[i][j] - 1;
                }
            }
        }
        System.out.println(n*100-count);

    }
}
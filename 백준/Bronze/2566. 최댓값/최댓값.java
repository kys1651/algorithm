import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int[][] arr = new int[9][9];
        int maxa = 0,maxb=0;
        for(int i = 0 ; i < 9 ; i++){
            st = new StringTokenizer((br.readLine()));
            for(int j = 0 ; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > arr[maxa][maxb]){
                    maxa = i;
                    maxb = j;
                }
            }

        }

        System.out.println(arr[maxa][maxb]);
        System.out.println((maxa + 1) + " " + (maxb + 1));
    }
}
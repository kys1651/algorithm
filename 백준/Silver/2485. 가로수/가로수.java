import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] gaps = new int[n - 1];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

            if(i > 0){
                gaps[i - 1] = arr[i] - arr[i - 1];
            }
        }
        for(int i = 0 ; i < gaps.length-1; i++){
            int max = gaps[i];
            int min = gaps[i+1];
            while(min != 0){
                int r = max % min;
                max = min;
                min = r;
            }
            gaps[i+1] = max;
        }
        System.out.println((arr[n-1]-arr[0])/gaps[gaps.length-1]+1 - n);
    }
}
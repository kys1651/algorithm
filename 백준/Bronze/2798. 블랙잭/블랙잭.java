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
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int a = 0; a  < n-2 ; a++){
            for(int b = a+1; b < n-1 ; b++){
                for(int c = b+1; c < n; c++){
                    int tmp = arr[a] + arr[b] + arr[c];
                    if(tmp <= m && tmp >= answer){
                        answer = tmp;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
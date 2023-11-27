import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n+m];
        int [] a = new int[n];
        int [] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        int adx = 0;
        int bdx = 0;
        int idx = 0;
        while(adx < n && bdx < m){
            if(a[adx] < b[bdx]){
                arr[idx++] = a[adx++];
            }else{
                arr[idx++] = b[bdx++];
            }
        }
        for(;adx<n;adx++){
            arr[idx++] = a[adx];
        }
        for(;bdx<m;bdx++){
            arr[idx++] = b[bdx];
        }
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }

}
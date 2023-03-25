import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        StringBuilder sb = new StringBuilder();
        String[] arr = new String[N + M];

        for(int i = 0; i < N+M; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < N+M-1; i++){
            if(arr[i].equals(arr[i+1])) {
                sb.append(arr[i++] + "\n");
                count++;
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
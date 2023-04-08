import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder("<");

        boolean[] arr = new boolean[n];
        int count = 0; // 점프 한 수
        int idx = 0; // 인덱스
        int check = 0; // 총 몇개를 넣었는지

        while(check != n){
            idx = idx % n;

            if(arr[idx] == false){
                count++;
            }
            if(count == k){
                arr[idx] = true;
                sb.append((idx+1) + (check==(n-1)?">":", "));
                count = 0;
                check++;
            }
            idx++;
        }
        System.out.println(sb);




    }
}
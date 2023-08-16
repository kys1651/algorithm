import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K,N;
    static int [] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // K : 보유중인 랜선의 개수 N : 필요한 랜선의 개수
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            // 랜선의 최대 길이를 구하기 위해서 for문 안에서 구해줌
            if(max < arr[i])
                max = arr[i];
        }

        max++;
        long min = 0;
        long mid = 0;
        // 이분 탐색
        while(min < max){
            mid = (max + min) / 2;
            long count = 0;


            // 만들 수 있는 랜선의 개수 : 랜선의 길이 / 자르는 길이
            for(int num : arr){
                count += num/mid;
            }

            // 만들 수 있는 랜선의 개수가 N보다 크거나 같으면 break;
            if(count >= N) {
                min = mid + 1;
            }else{
                // 랜선의 개수가 더 적다는 것은 랜선의 길이를 더 줄여야 한다
                // 즉, 상한을 줄여야 함.
                max = mid;
            }


        }
        System.out.println(min-1);

    }
}

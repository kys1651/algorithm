import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int [] trees;
    static int H;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            // 나무의 최대값을 구하기 위해서 for문에서 구해줌
            if(max < trees[i])
                max = trees[i];
        }

        // 이분 탐색
        while(min < max){

            int mid = (min + max) / 2;
            long sum = 0;

            // tree의 잘린길이 : tree의 높이 - 자르는 높이
            // 0보다 클 때 더해주어야한다.
            for(int tree: trees){
                if (tree - mid > 0) {
                    sum += (tree-mid);
                }
            }

            // 자른 나무의 합이 M보다 작다는 것은 자르는 높이를 더 낮춰야 함
            // 즉, 상한을 줄여야한다.
            if(sum < M){
                max = mid;
            }
            // 자른 나무의 합이 M보다 크다는 것은 자르는 높이를 더 높여줘야 함
            // 즉, 하한을 높여야한다.
            else{
                min = mid + 1;
            }

        }
        System.out.println(min - 1);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }// Input End
        Arrays.sort(A);

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(search(B,A[i])){
                sb.append(A[i]).append(' ');
                count++;
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }

    private static boolean search(int[] arr, int tmp) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= tmp) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr[end] != tmp;
    }
}

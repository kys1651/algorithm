import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] arr;
    static int[] tmp;
    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmp = new int[N];
        count = K;
        answer = -1;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr,0,N-1);
        System.out.println(answer);
    }

    // A 오름차순 정렬
    static void merge_sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // q는 p와 q의 중간지점
            merge_sort(A, p, q); // 전반부 정렬
            merge_sort(A, q + 1, r); // 후반부 정렬
            merge(A, p, q, r); // 병합
        }
    }

    // A(전반부)와 A(후반부)를 병합하여 A를 오름차순 정렬된 상태로 만든다.
    // 각 배열은 이미 정렬되어 있음
    static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int t = 0;

        while(i <= q && j <= r){
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }
        while(j <= r){
            tmp[t++] = A[j++];
        }

        i = p;
        t = 0;

        while (i <= r) {
            A[i++] = tmp[t++];
            count--;
            if(count == 0) answer = A[i-1];
        }
    }
}
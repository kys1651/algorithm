import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= N; i ++){
            q.add(i);
        }

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < M; i++){

            int target_idx = q.indexOf(arr[i]);
            int half_idx;

            if (q.size() % 2 == 0) {
                half_idx = q.size() / 2 - 1;
            }else{
                half_idx = q.size() / 2 ;
            }

            if (target_idx <= half_idx) {
                for (int j = 0; j < target_idx; j++) {
                    q.offerLast(q.pollFirst());
                    count++;
                }
            }else{
                for (int j = 0; j < q.size() - target_idx; j++) {
                    q.offerFirst(q.pollLast());
                    count++;
                }
            }
            q.pollFirst();
        }

        System.out.println(count);
    }
}

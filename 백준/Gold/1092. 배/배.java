import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] crane= new int[N];

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }// Input End
        Arrays.sort(crane);

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        // Input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }// Input End
        box.sort(Collections.reverseOrder());

        if (crane[N-1] < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int t = 0;
        while (!box.isEmpty()) {
            int craneIdx = N - 1, boxIdx = 0;
            while (craneIdx >= 0 && boxIdx < box.size()) {
                if(crane[craneIdx] >= box.get(boxIdx)) {
                    box.remove(boxIdx);
                    craneIdx--;
                }else{
                    boxIdx++;
                }
            }
            t++;
        }

        System.out.println(t);

    }
}
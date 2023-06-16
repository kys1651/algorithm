import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new int[]{a, b});
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(check(list.get(i), list.get(j)))
                    count++;
            }
            answer[i] = count + 1;
        }

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }

    private static boolean check(int[] a, int[] b) {
        if(a[0] < b[0] && a[1] < b[1])
            return true;
        else
            return false;
    }
}

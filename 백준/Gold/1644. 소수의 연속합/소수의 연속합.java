import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        getPrime();

        int left = 0, right = 0;
        int ans = 0, sum = 0;
        int size = list.size();

        while(true){
            if(sum >= n){
                sum -= list.get(left++);
            }else if(right == size){
                break;
            }else {
                sum += list.get(right++);
            }
            if(sum == n) ans ++;
        }
        System.out.println(ans);

    }

    private static void getPrime() {
        int[] tmp = new int[n + 1];
        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= n; i++) {
            tmp[i] = i;
        }

        for (int i = 2; i <= root; i++) {
            if(tmp[i] == 0) continue;

            for (int j = i * 2; j <= n; j += i) {
                tmp[j] = 0;
            }
        }

        for (int i = 2; i <= n; i++) {
            if(tmp[i] == 0) continue;

            list.add(tmp[i]);
        }

    }


}

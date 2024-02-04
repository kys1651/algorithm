import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bit = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        if (n >= 1023) {
            System.out.println(-1);
            return;
        } else if(n <= 10){
            System.out.println(n);
            return;
        }


        ArrayList<Long> list = new ArrayList<>();

        for (int i = 1; i < (1 << 10); i++) {
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    sum = sum * 10 + bit[j];
                }
            }
            list.add(sum);
        }

        Collections.sort(list);
        System.out.println(list.get(n));
    }
}

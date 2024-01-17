import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] texts = new String[n];
        for (int i = 0; i < n; i++) {
            texts[i] = br.readLine();
        }
        final int SIZE = 26;
        int[] nums = new int[SIZE];
        for (int i = 0; i < n; i++) {
            String word = texts[i];
            for (int j = 0; j < word.length(); j++) {
                nums[word.charAt(j) - 'A'] += (int)Math.pow(10,word.length() - 1 - j);
            }
        }

        Arrays.sort(nums);

        int sum = 0;
        int value = 9;
        int idx = 25;
        while (nums[idx] != 0) {
            sum += nums[idx] * value;
            value--;
            idx--;
        }

        System.out.println(sum);
    }
}

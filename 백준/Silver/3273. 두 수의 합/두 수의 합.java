import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(num);
        int result = 0;
        int left = 0, right = n - 1;
        while(left < right){
            int sum = num[left] + num[right];
            if(sum == x){
                result++;
                left++; right --;
            }else if(sum < x){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(result);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int num = Integer.parseInt(br.readLine());
        while(num != 0){
            result += num % 10;
            num /= 10;
        }
        System.out.println(result);
	}
}
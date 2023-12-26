import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String num = br.readLine();
        for(char n : num.toCharArray()){
            result += n - '0';
        }
        System.out.println(result);
	}
}
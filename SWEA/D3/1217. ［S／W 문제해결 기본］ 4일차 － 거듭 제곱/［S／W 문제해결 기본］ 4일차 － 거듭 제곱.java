import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append("#" + tc + " " + pow(n,m)).append("\n");
		}
        System.out.println(sb);
	}
    private static int pow(int base, int exponent){
        int result = 1;

        while(exponent != 0){
            if(exponent % 2 != 0){
                result *= base;
                exponent -= 1;
            }
            base *= base;
            exponent /= 2;
            }
        
        return result;
    }
}
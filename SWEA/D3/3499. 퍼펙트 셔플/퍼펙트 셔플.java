import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            String[] cards = new String[n];
            for(int i = 0; i < n; i++){cards[i] = sc.next();}
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n/2; i++){
                sb.append(cards[i] + " ");
                sb.append(cards[i + (n / 2 + n % 2)] + " ");
            }
            if(n % 2 != 0){
                sb.append(cards[n / 2]);
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
	}
}
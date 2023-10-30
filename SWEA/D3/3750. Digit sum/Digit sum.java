import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String n = sc.next();
            while(n.length() != 1){
                int tmp = 0;
                for(char ch : n.toCharArray()){
                    tmp += ch - '0';
                }
                n = String.valueOf(tmp);
            }
            System.out.println("#" + tc + " " + n);
		}
	}
}
import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            String m = Integer.toBinaryString(sc.nextInt());
            if(m.length() < n){
                int len = n - m.length();
                for(int i = 0; i < len ; i++) m = "0" + m;
            }
            m = m.substring(m.length() - n);
            System.out.println("#" + tc + " " + (m.contains("0")? "OFF" : "ON"));
		}
	}
}
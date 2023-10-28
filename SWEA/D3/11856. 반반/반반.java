import java.util.Scanner;
import java.util.HashSet;
class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String str = sc.next();
            HashSet<Character> set = new HashSet<>();
            for(char ch : str.toCharArray()){
                set.add(ch);
            }
            System.out.println("#" + tc +  " " + (set.size() == 2?"Yes":"No"));
		}
	}
}
import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{

            String[] strs = new String[5];
            int maxLen = 0;
            for(int i = 0; i < 5; i++){
                strs[i] = sc.next();
                maxLen = Math.max(maxLen, strs[i].length());
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i < maxLen; i++){
                for(int j = 0; j < 5; j++){
                    if(strs[j].length() > i) 
                        System.out.print(strs[j].charAt(i));
                }
            }
            System.out.println();
        }
	}
}
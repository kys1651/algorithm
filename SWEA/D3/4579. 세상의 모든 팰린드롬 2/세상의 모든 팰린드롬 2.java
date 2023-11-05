import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            String text = sc.next();
            String result = "Exist";
            for(int i = 0; i < text.length() / 2; i++){
                char front = text.charAt(i);
                char back = text.charAt(text.length() - 1 - i);
                if(front != back){
                    if(front != '*' && back != '*') result  = "Not exist";
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}
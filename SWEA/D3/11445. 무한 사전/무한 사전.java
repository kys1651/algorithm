import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc= 1; tc <= T; tc++) {
            String a = sc.next().trim();
            String b = sc.next().trim();
            if((a + "a").compareTo(b) < 0){
                System.out.println("#" + tc + " Y");
            }else{
                System.out.println("#" + tc + " N");
            }
            
		}
	}
}
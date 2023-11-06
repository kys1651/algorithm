import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T= sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int answerS = sc.nextInt();
            int answerE = sc.nextInt();
            int answerM = sc.nextInt();
            int s = 1;
            int e = 1;
            int m = 1;
            int result = 1;
            while(!(s == answerS && e == answerE && m == answerM)){
                s++; e++; m++;
                result++;
                if(s == 366) {s = 1; }
                if(e == 25) {e = 1; }
                if(m == 30) {m = 1; }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}
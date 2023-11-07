import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            String[] strArr = (" " + sc.next()).split("");
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){ strArr[sc.nextInt()] += "-"; }
			StringBuilder sb = new StringBuilder();
            for(String str : strArr) sb.append(str);
            System.out.println("#" + tc + " " + sb.toString().trim());
		}
	}
}
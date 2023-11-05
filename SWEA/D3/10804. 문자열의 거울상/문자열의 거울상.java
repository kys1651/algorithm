import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            String str = sc.next();
            for(char ch : str.toCharArray()){
                switch(ch){
                    case 'b': sb.append("d"); break;
                    case 'd': sb.append("b"); break;
                    case 'p': sb.append("q"); break;
                    case 'q': sb.append("p"); break;
                }
            }
            System.out.println("#" + tc + " " + sb.reverse());
		}
	}
}
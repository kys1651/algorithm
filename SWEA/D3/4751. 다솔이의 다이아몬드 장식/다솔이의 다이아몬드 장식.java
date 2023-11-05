import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
        char[][] mark = {{'.','.','#','.','.'}, {'.','#','.','#','.'},{'#','.','?','.','#'}};
		for(int test_case = 1; test_case <= T; test_case++) {
            String text = sc.next();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for(int i = 0; i < text.length(); i++){
                sb1.append("..#.");
                sb2.append(".#.#");
                sb3.append("#." + text.charAt(i) +".");
            }
            sb1.append(".");
            sb2.append(".");
            sb3.append("#");
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
            System.out.println(sb3.toString());
            System.out.println(sb2.toString());
            System.out.println(sb1.toString());
        }
    }
}

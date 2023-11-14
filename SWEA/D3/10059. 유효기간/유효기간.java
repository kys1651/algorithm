import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            String word = sc.next();
            int front = Integer.valueOf(word.substring(0,2));
            int back = Integer.valueOf(word.substring(2));
            boolean checkA = (front < 1 || front > 12) ? true : false;
            boolean checkB = (back < 1 || back> 12) ? true : false;
            
            String result = "AMBIGUOUS";
            if(checkA && checkB){
                result = "NA";
            }else if(checkA && !checkB){
                result = "YYMM";
            }else if(!checkA && checkB){
                result = "MMYY";
            }
            System.out.println("#" + tc + " " + result);
        }
	}
}
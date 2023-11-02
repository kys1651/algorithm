import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int count = 0;
            int check = 0;
            while(count != n){
                String word = sc.next();
                if(Character.isUpperCase(word.charAt(0)) && word.substring(1).toLowerCase().replaceAll("[0-9]","").equals(word.substring(1))){
                    check++;
                }
                if(word.contains("!") || word.contains("?") || word.contains(".")){
                    count++;
                    sb.append(check).append(" ");
                    check = 0;
                }
            }
            System.out.println("#" + tc + " "+ sb.toString());
        }
	}
}
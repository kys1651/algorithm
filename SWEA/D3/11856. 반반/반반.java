import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String str = sc.next();
            String result = "Yes";
            str = str.replaceAll(String.valueOf(str.charAt(0)),"");
            if(str.length() != 2){
                result = "No";
            }
            if(str.length() == 2 && str.replaceAll(String.valueOf(str.charAt(0)),"").length() != 0){
                result = "No";
            }
            System.out.println("#" + tc +  " " + result);
		}
	}
}
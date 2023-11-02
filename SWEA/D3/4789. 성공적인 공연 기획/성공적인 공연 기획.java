import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String peoples = sc.next();
            int clap = 0;
            int employ = 0;
            for(int i = 0; i < peoples.length(); i++){
                if(peoples.charAt(i) == '0') continue;
                else if(clap < i)  {
                    employ += i - clap;
                    clap += i - clap;
                }
                clap += (peoples.charAt(i) - '0');
            }
            System.out.println("#" + tc + " " + employ);
        }
	}
}
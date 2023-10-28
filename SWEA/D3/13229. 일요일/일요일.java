import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		for(int tc = 1; tc <= T; tc++)
		{
            String day = sc.next();
            int result = 0;
            for(int i = 0; i < days.length; i++){
                if(days[i].equals(day)){
                    result = days.length - i - 1;
                }
            }
            System.out.println("#" + tc + " " + (result == 0?7 : result));
		}
	}
}
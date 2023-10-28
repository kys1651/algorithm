import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int [] customers = new int[n];
            for(int i = 0; i <n ; i++){
                customers[i] = sc.nextInt();
            }
            Arrays.sort(customers);
            int time = 0;
            int makeTime = 0,makeCount = 0;
            int idx = 0;
            String result = "Possible";
            while(time <= customers[n-1]){
                if(makeTime == m){
                    makeCount += k;
                    makeTime = 0;
                }
                if(customers[idx] == time){
                    makeCount--;
                    idx++;
                }
                if(makeCount < 0){
                    result = "Impossible";
                    break;
                }
                time++; makeTime++;
            }
            
            System.out.println("#" + tc + " " + result);
		}
	}
}
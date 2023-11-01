import java.util.*;
class Solution
{
    static int[] nums;
    static boolean[] visit;
    static ArrayList<Integer> list;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            nums = new int[7];
            visit = new boolean[7];
            list = new ArrayList<>();
            for(int i = 0; i <7; i++){ nums[i] = sc.nextInt(); }
            go(0,0,0);
            Collections.sort(list,(o1,o2)->o2-o1);
            System.out.println("#" + tc + " " + list.get(4));
		}
	}
    private static void go(int depth, int count, int sum){
        if(count == 3){
            if(!list.contains(sum)) list.add(sum);
            return;
        }
        
        for(int i = depth; i < 7; i++){
            if(visit[i]) continue;
            visit[i] = true;
            go(i,count+1,sum + nums[i]);
            visit[i] =false;
        }
    }
}
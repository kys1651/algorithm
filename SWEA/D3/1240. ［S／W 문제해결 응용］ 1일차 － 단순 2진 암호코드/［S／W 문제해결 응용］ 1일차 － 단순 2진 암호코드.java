import java.util.*;
class Solution{
    public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String[] nums = {"0001101", "0011001", "0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] info = new String[n];
            for(int i = 0; i < n; i++){
                info[i] = sc.next();
            }
            int[] answer = new int[8];
            int count = 7;
            int even = 0;
            int odd = 0;
            for(int i = 0; i < n; i++){
                if(!info[i].contains("1")) continue;
                int idx = info[i].lastIndexOf("1") + 1;
                while(count != -1){
                    answer[count] = map.get(info[i].substring(idx - 7,idx));
                    if(count % 2 == 0){
                        odd += answer[count];
                    }else{
                        even += answer[count];
                    }
                    count--;
                    idx -= 7;
                }
                break;
            }
            int result = odd + even;
            if((odd * 3 + even) % 10 != 0){
                result = 0;
            }
            System.out.println("#" + tc + " " + result);
        }
	}
}
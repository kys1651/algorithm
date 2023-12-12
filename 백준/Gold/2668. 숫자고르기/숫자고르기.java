import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
    static int[] nums;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        answer = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1; i <= n ;i++){
            if(!answer.contains(i)){
                dfs(i,i);
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int num : answer){
            System.out.println(num);
        }
    }
    private static void dfs(int pos, int goal) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pos);
        stack.push(pos);
        while(!stack.isEmpty()){
            int n = stack.pop();
            if(nums[n] == goal){
                for(int num : list){
                    answer.add(num);
                }
                return;
            }
            if(!answer.contains(nums[n])&&!list.contains(nums[n])){
                list.add(nums[n]);
                stack.push(nums[n]);
            }
        }

    }
}
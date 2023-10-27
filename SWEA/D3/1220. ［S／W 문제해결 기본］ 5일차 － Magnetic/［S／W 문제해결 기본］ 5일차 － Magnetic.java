import java.util.Scanner;
import java.util.Stack;

class Solution
{
    static int SIZE = 100;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++)
		{
            sc.next();
            int[][] map = new int[SIZE][SIZE];
            for(int i = 0; i < SIZE; i ++){
                for(int j = 0; j < SIZE; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int result = check(map);
            System.out.println("#" + tc + " " + result);
        }
    }
    private static int check(int[][] map){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < SIZE; i++){
            stack.clear();
            for(int j = 0; j < SIZE; j ++){
                if(map[j][i] == 0){
                    continue;
                }
                if((stack.isEmpty() && map[j][i] == 2) || (!stack.isEmpty() && stack.peek() == map[j][i])){
                    continue;
                }
                stack.push(map[j][i]);
            }
            while(!stack.isEmpty() && stack.peek() == 1){
                stack.pop();
            }
            result += (stack.size()/ 2);
        }
        return result;
    }
}
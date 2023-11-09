import java.util.Scanner;
class Solution {
    static int [] answer;
    static int[] tree;
    static int n,k;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int degree = sc.nextInt();
            n = (int)Math.pow(2,degree) - 1;
            tree = new int[n];
            answer = new int[n];
            for(int i = 0; i < n; i++) tree[i] = sc.nextInt();
            search(0,n-1,1);

            System.out.print("#" + tc + " ");
            int i = 0;
            int idx = 0;
            int count = 0;
            while(idx < n){
                for(int j = 0; j < Math.pow(2,i); j++){
                    System.out.print(answer[idx++]+ " ");
                }
                System.out.println();
                i++;
            }
        }
	}
    private static void search(int start, int end, int depth){
        if(end < 0 || start > n || depth > n) return;
        
        int idx = (start + end) / 2;
        answer[depth-1] = tree[idx];
        if(start == end) return;
        search(start, idx - 1, depth * 2);
        search(idx + 1, end, 2 * depth + 1);
    }
}
import java.util.Scanner;
class Solution
{
    static int[] a;
    static int[] b;
    static int[] arr;
    static boolean[] visit;
    static int win;
    static int lose;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            a = new int[9];
            b = new int[9];
            arr = new int[9];
            visit = new boolean[9];
            win = 0; lose = 0;
            boolean[] check = new boolean[19];
            for(int i = 0; i < 9; i++){
                a[i] = sc.nextInt();
                check[a[i]] = true;
            }
            for(int i = 1,j=0; i <check.length; i++){
                if(!check[i]) b[j++] = i ;
            }
            go(0);
            System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
    
    private static void go(int depth){
        if(depth == 9){
            int count = 0;
            for(int i = 0; i < 9; i++){
                int sum = a[i] + arr[i];
                if(a[i] < arr[i]){
                    count += sum;
                }else{
                    count -= sum;
                }
            }
            if(count > 0){ lose ++; }
            else if(count < 0){ win++;}
            return;
        }
        
        for(int i = 0; i < 9; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = b[i];
                go(depth+1);
                visit[i] = false;
            }
        }
    }
}
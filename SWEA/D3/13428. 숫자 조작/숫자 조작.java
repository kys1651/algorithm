import java.util.Scanner;
class Solution
{
    static int max;
    static int min;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            char[] strN = String.valueOf(n).toCharArray();
            max = n;
            min = n;
            solution(0,0,strN);
            System.out.println("#" + tc + " " + min + " " + max);
		}
	}
    private static void solution(int at,int count,char[] arr){
        if(count == 1 || at == arr.length){
            String tmp = new String(arr);
            if(!tmp.startsWith("0")){
                max = Math.max(max, Integer.valueOf(tmp));
                min = Math.min(min, Integer.valueOf(tmp));
            }
            return;
        }
        for(int i = at; i < arr.length; i++){
            swap(at,i,arr);
            solution(i+1,count + 1,arr);
            swap(at,i,arr);
            solution(i+1,count,arr);
        }
    }
    
    private static void swap(int i ,int j, char[] arr){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
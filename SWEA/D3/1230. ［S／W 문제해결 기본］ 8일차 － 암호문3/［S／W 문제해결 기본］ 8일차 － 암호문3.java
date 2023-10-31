import java.util.LinkedList;
import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < n; i++){ list.add (sc.nextInt()); }
            int m = sc.nextInt();
            for(int i = 0; i < m; i++){
                String command = sc.next();
                if(command.equals("I")){
                    int idx = sc.nextInt();
                    int count = sc.nextInt();
                    while(count --> 0){ list.add(idx++, sc.nextInt()); }
                }else if(command.equals("D")){
                    int idx = sc.nextInt();
                    int count = sc.nextInt();
                    while(count --> 0){ list.remove(idx); }
                }else{
                    int count = sc.nextInt();
                    while(count --> 0){ list.add(sc.nextInt()); }
                }
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i < 10; i++){
                System.out.print(list.get(i) + " " );
            }
            System.out.println();
		}
	}
}
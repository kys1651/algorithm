import java.util.Scanner;
import java.util.LinkedList;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < n; i++){ list.add(sc.nextInt());}
            int c = sc.nextInt();
            for(int i = 0; i < c; i++){
                String cmd = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(cmd.equals("I")){
                    while(y --> 0){
                        list.add(x++,sc.nextInt());
                    }
                }
                else{
                   while(y --> 0){
                        list.remove(x);
                    }
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
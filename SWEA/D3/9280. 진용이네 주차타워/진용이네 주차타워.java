import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
            int m = sc.nextInt();
            int[] rate = new int[n];
            int[] weight = new int[m];
            int[] parking = new int[m];
            boolean[] canP = new boolean[n];
            Queue<Integer> wating = new LinkedList<>();
            int sum = 0;
            int size = 0;
            for(int i = 0; i < n; i ++){ rate[i] = sc.nextInt(); }
            for(int i = 0; i < m; i++) { weight[i] = sc.nextInt(); } 
            for(int i = 0; i < 2 *m; i++){
                int car = sc.nextInt();
                if(car > 0){
                    if(size < n){
                        for(int j = 0; j < n; j++){
                            if(!canP[j]){
                                parking[car-1] = j;
                                canP[j] = true;
                                size++;
                                break;
                            }
                        }
                    } 
                    else{ wating.offer(car); }
                }
                else{
                    car = Math.abs(car)-1;
                    sum += rate[parking[car]] * weight[car];
                    canP[parking[car]] = false;
                    size--;
                    if(!wating.isEmpty()){
                        for(int j = 0; j < n; j++){
                            if(!canP[j]){
                                canP[j] = true;
                                parking[wating.poll()-1] = j;
                                size++;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
	}
}
import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            HashMap<Character, Integer> map = new HashMap<>();
            ArrayList<Character> list = new ArrayList<>();
            for(char ch : str.toCharArray()){
                map.put(ch, map.getOrDefault(ch,0) + 1);
            }
            for(char ch : map.keySet()){
                if(map.get(ch) % 2 != 0){
                    list.add(ch);
                }
            }
            Collections.sort(list);
            System.out.print("#" + tc + " ");
            if(list.isEmpty()) {System.out.print("Good");}
            else{for(char ch : list) System.out.print(ch);}
            System.out.println();
        }
	}
}
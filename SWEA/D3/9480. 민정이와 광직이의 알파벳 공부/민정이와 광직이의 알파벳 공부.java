import java.util.*;
class Solution {
    public static int answer,n;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            answer = 0;
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = sc.next().toLowerCase();
            }
            combination(0,words,new HashSet<Character>());
            System.out.println("#" + tc + " " + answer);
        }
    }
    private static void combination(int depth, String[] words, HashSet<Character> s) {
        HashSet<Character> hs = new HashSet<>(s);
        if (depth == n) {
            if(hs.size() == 26) answer++;
            return;
        }
        combination(depth+1, words, hs);
		for(char ch : words[depth].toCharArray()){
            hs.add(ch);
        }
        combination(depth+1, words, hs);
    }
}

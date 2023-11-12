import java.util.Scanner;

class Solution {
    public static int answer;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            answer = 0;
            String[] words = new String[n];
            boolean[] visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                words[i] = sc.next().toLowerCase();
            }
            combination(0, n, words, visit);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static boolean check(String[] words, boolean[] visit) {
        int[] alpha = new int[26];
        for (int i = 0; i < words.length; i++) {
            if (visit[i]) {
                for (char ch : words[i].toCharArray()) {
                    alpha[ch - 'a']++;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private static void combination(int start, int end, String[] words, boolean[] visit) {
        if (start == end) {
            if (check(words, visit)) {
                answer++;
            }
            return;
        }
        visit[start] = true;
        combination(start + 1, end, words, visit);
        visit[start] = false;
        combination(start + 1, end, words, visit);
    }
}

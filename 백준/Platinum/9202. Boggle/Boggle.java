import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
    public static class Trie {
        Trie[] children;
        int depth;
        boolean isEnd;

        public Trie(int depth) {
            this.depth = depth;
            children = new Trie[26];
        }

        public void insert(String word, int idx) {
            if (idx == word.length()) {
                isEnd = true;
                return;
            }

            int index = word.charAt(idx) - 'A';
            if (children[index] == null) {
                children[index] = new Trie(depth + 1);
            }
            children[index].insert(word, idx + 1);
        }
    }

    private static char[][] map;
    private static boolean[][] visited;
    private static Stack<Integer> path;

    private static int[] dirX = {-1, 1, 0, 0, -1, -1, -1, 1, 1};
    private static int[] dirY = {0, 0, -1, 1, -1, 0, 1, 1, -1};

    private static TreeSet<String> resultWord;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie root = new Trie(0);

        for (int i = 0; i < N; i++) {
            root.insert(br.readLine(), 0);
        }
        br.readLine();

        path = new Stack<>();
        map = new char[4][4];
        visited = new boolean[4][4];
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            if (tc != 0) br.readLine();
            // Input
            for (int i = 0; i < 4; i++) {
                String input = br.readLine();
                for (int j = 0; j < 4; j++) {
                    map[i][j] = input.charAt(j);
                }
            }// Input End

            resultWord = new TreeSet<>((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int idx = map[i][j] - 'A';
                    if (root.children[idx] == null) continue;
                    visited[i][j] = true;
                    path.push(idx);
                    solve(root.children[idx], i, j, 1);
                    path.pop();
                    visited[i][j] = false;
                }
            }
            String maxWord = resultWord.pollFirst();
            int resultScore = getScore(maxWord);
            int resultCount = 1;
            while (!resultWord.isEmpty()) {
                resultCount++;
                resultScore += getScore(resultWord.pollFirst());
            }
            answer.append(resultScore).append(" ").append(maxWord).append(" ").append(resultCount).append('\n');
        }
        System.out.println(answer);
    }

    private static int getScore(String word) {
        int len = word.length();
        if (len == 3 || len == 4) {
            return 1;
        } else if (len == 5) {
            return 2;
        } else if (len == 6) {
            return 3;
        } else if (len == 7) {
            return 5;
        } else if (len == 8) {
            return 11;
        } else {
            return 0;
        }
    }

    private static void solve(Trie cur, int x, int y, int len) {
        if (len == 9) {
            return;
        }
        if (cur.isEnd) {
            StringBuilder tmpSb = new StringBuilder();
            for (int p : path) {
                tmpSb.append((char) ('A' + p));
            }
            resultWord.add(tmpSb.toString());
        }

        for (int i = 0; i < dirX.length; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (!isIn(nX, nY) || visited[nX][nY]) {
                continue;
            }

            int idx = map[nX][nY] - 'A';
            if (cur.children[idx] == null) {
                continue;
            }
            visited[nX][nY] = true;
            path.push(idx);
            solve(cur.children[idx], nX, nY, len + 1);
            path.pop();
            visited[nX][nY] = false;
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
}
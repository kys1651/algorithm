import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static class Trie {
        int count;
        Trie[] children;

        public Trie() {
            count = 0;
            children = new Trie[26];
        }

        public void insert(String word, int index) {
            if (index == word.length()) {
                return;
            }

            int idx = word.charAt(index) - 'a';
            if (children[idx] == null) {
                children[idx] = new Trie();
            }
            children[idx].addCount();
            children[idx].insert(word, index + 1);
        }

        public void addCount() {
            count++;
        }

        public double totalSum() {
            if (count == 1) {
                return 0.0;
            }
            double sum = 0.0;
            for (int i = 0; i < 26; i++) {
                Trie trie = children[i];
                if (trie != null) {
                    if (this.count == 0 || trie.count < count) {
                        sum += trie.count;
                    }
                    sum += trie.totalSum();
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if(input == null || input.isEmpty()) break;

            int n = Integer.parseInt(input);
            Trie rootTrie = new Trie();

            for (int i = 0; i < n; i++) {
                rootTrie.insert(br.readLine(), 0);
            }
            double result = rootTrie.totalSum() / n;
            sb.append(String.format("%.2f", result)).append('\n');
        }
        System.out.println(sb);
    }
}
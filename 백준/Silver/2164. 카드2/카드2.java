import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N; i ++){
            q.add(i);
        }

        while (q.size() != 1) {
            q.pollFirst();
            q.addLast(q.pollFirst());
        }
        System.out.println(q.pop());
    }
}

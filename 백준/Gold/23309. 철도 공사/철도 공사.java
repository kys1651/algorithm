import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int next;
        int prev;

        public Node() {
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("next=").append(next);
            sb.append(", prev=").append(prev);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[1000001];

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        nodes[first] = new Node();
        int prev = first;
        for (int i = 1; i < N - 1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            nodes[tmp] = new Node();
            nodes[tmp].prev = prev;
            nodes[prev].next = tmp;
            prev = tmp;
        }
        int next = Integer.parseInt(st.nextToken());
        nodes[prev].next = next;
        nodes[next] = new Node();
        nodes[next].prev = prev;
        nodes[next].next = first;
        nodes[first].prev = next;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String Command = st.nextToken(); // 명령어
            int idx = Integer.parseInt(st.nextToken()); // 기준 인덱스

            if (Command.equals("BN")) {
                int tmp = Integer.parseInt(st.nextToken());
                nodes[tmp] = new Node();

                // 다음 인덱스 값 찾아오기
                next = nodes[idx].next;

                // 새로운 지하철 생성
                nodes[tmp].next = next;
                nodes[tmp].prev = idx;

                // 새로운 지하철 연결
                nodes[idx].next = tmp;
                nodes[next].prev = tmp;

                sb.append(next);
            } else if (Command.equals("BP")) {
                int tmp = Integer.parseInt(st.nextToken());
                nodes[tmp] = new Node();

                // 이전 인덱스 값 찾아오기
                prev = nodes[idx].prev;

                // 새로운 지하철 생성
                nodes[tmp].next = idx;
                nodes[tmp].prev = prev;

                // 새로운 지하철 연결
                nodes[idx].prev = tmp;
                nodes[prev].next = tmp;

                sb.append(prev);
            } else if (Command.equals("CN")) {
                // 다음 노드의 인덱스
                next = nodes[idx].next;
                nodes[idx].next = nodes[next].next;
                nodes[nodes[next].next].prev = idx;

                // 지하철 지워줌
                nodes[next] = null;

                sb.append(next);
            }else{
                // 이전 노드의 인덱스
                prev = nodes[idx].prev;
                nodes[idx].prev = nodes[prev].prev;
                nodes[nodes[prev].prev].next = idx;

                // 지하철 제거
                nodes[prev] = null;

                sb.append(prev);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}


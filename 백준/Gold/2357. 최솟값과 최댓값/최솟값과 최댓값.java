import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int treeSize = getTreeSize(N);
        minTree = new int[treeSize];
        maxTree = new int[treeSize];

        minInit(arr, 1, 1, N);
        maxInit(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(minFind(1, 1, N, a, b)).append(' ').append(maxFind(1, 1, N, a, b)).append('\n');
        }
        System.out.println(sb);
    }

    private static int maxFind(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Integer.MIN_VALUE;
        }

        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) >> 1;
        return Math.max(maxFind(node * 2, start, mid, left, right), maxFind(node * 2 + 1, mid + 1, end, left, right));
    }

    private static int minFind(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) >> 1;
        return Math.min(minFind(node * 2, start, mid, left, right), minFind(node * 2 + 1, mid + 1, end, left, right));
    }

    private static int minInit(int[] arr, int node, int start, int end) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) >> 1;
        return minTree[node] = Math.min(minInit(arr, node * 2, start, mid), minInit(arr, node * 2 + 1, mid + 1, end));
    }

    private static int maxInit(int[] arr, int node, int start, int end) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }
        int mid = (start + end) >> 1;
        return maxTree[node] = Math.max(maxInit(arr, node * 2, start, mid), maxInit(arr, node * 2 + 1, mid + 1, end));
    }

    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        return (int) Math.pow(2, h + 1);
    }
}
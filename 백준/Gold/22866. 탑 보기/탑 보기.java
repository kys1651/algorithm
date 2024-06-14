import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Stack {
        Building[] element;
        int top;
        int size;

        public Stack(int size) {
            this.size = size;
            element = new Building[size];
            this.top = -1;
        }

        public void push(Building b) {
            if (top == size - 1) {
                return;
            }
            element[++top] = b;
        }

        public Building peek() {
            return element[top];
        }

        public Building pop() {
            return element[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
    }

    static class Building {
        int idx;
        int height;

        public Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        int[] count = new int[N]; 
        int[] mem = new int[N]; 
        Building[] buildings = new Building[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
            mem[i] = -1;
        }// Input End

        Stack left = new Stack(N);
        Stack right = new Stack(N);
        for (int i = 0; i < N; i++) {
            removeHeight(left, buildings, count, i);
            if (!left.isEmpty()) {
                setIdx(mem, i, left.peek().idx);
            }
            left.push(buildings[i]);

            removeHeight(right, buildings, count, N - i - 1);
            if (!right.isEmpty()) {
                setIdx(mem, N - i - 1, right.peek().idx);
            }
            right.push(buildings[N - i - 1]);
        }
        while (!left.isEmpty()) {
            Building b = left.pop();
            count[b.idx] += left.size();
        }

        while (!right.isEmpty()) {
            Building b = right.pop();
            count[b.idx] += right.size();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(count[i]);
            if (count[i] != 0) {
                sb.append(' ').append(mem[i] + 1);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void removeHeight(Stack stack, Building[] buildings, int[] count, int idx) {
        while (!stack.isEmpty() && stack.peek().height <= buildings[idx].height) {
            Building b = stack.pop();
            count[b.idx] = count[b.idx] + stack.size();
        }
    }

    private static void setIdx(int[] mem, int i, int idx) {
        if (mem[i] == -1) mem[i] = idx;
        int originDist = Math.abs(i - mem[i]);
        int newDist = Math.abs(i - idx);
        if (originDist > newDist || (originDist == newDist && idx < mem[i])) {
            mem[i] = idx;
        }
    }
}
import java.util.*;

import java.io.*;

public class Main {
	static class Box implements Comparable<Box> {
		int idx;
		int width;
		int height;
		int weight;

		public Box(int idx, int width, int height, int weight) {
			super();
			this.idx = idx;
			this.width = width;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Box b) {
			return b.width - this.width;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Box[] boxes = new Box[N];
		// Input
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			boxes[i] = new Box(i, width, height, weight);
		} // Input End
		Arrays.sort(boxes);

		int[] height = new int[N];
		int[] prev = new int[N];
		for (int i = 0; i < N; i++) {
			Box cur = boxes[i];
			height[i] = cur.height;
			prev[i] = -1;
			for (int j = 0; j < i; j++) {
				if (boxes[j].width > cur.width && boxes[j].weight > cur.weight) {
					if (height[i] < height[j] + cur.height) {
						height[i] = height[j] + cur.height;
						prev[i] = j;
					}
				}
			}
		}
		int start = 0, max = 0;
		for (int i = 0; i < N; i++) {
			if (max < height[i]) {
				max = height[i];
				start = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = start; i != -1; i = prev[i]) {
			sb.append(boxes[i].idx + 1).append('\n');
			count++;
		}
		System.out.println(count);
		System.out.println(sb);
	}
}

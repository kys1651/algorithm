import java.util.*;
import java.io.*;

public class Main {
    static class Cat implements Comparable<Cat> {
        int idx;
        boolean isCat;

        public Cat(int idx, boolean isCat) {
            this.idx = idx;
            this.isCat = isCat;
        }

        @Override
        public int compareTo(Cat o) {
            return idx - o.idx;
        }
    }

    static HashMap<Integer, ArrayList<Cat>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 고양이 위치 받아오기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            addCat(x, y);
        }// 고양이 위치 입력 끝

        int answer = 0;
        for (ArrayList<Cat> catList : map.values()) {
            answer += getCount(catList);
        }
        System.out.println(answer);
    }

    private static int getCount(ArrayList<Cat> catList) {
        int count = 0;
        Collections.sort(catList);

        boolean isDead = false;
        for (Cat cat : catList) {
            if (cat.isCat) {
                if (!isDead) {
                    count++;
                    isDead = true;
                }
            } else {
                isDead = false;
            }
        }
        return count;
    }

    private static void addCat(int x, int y) {
        ArrayList<Cat> catPos = map.getOrDefault(x, new ArrayList<>());
        ArrayList<Cat> catDownPos = map.getOrDefault(x + 1, new ArrayList<>());
        catPos.add(new Cat(y, true));
        catDownPos.add(new Cat(y, false));
        map.put(x, catPos);
        map.put(x + 1, catDownPos);
    }
}

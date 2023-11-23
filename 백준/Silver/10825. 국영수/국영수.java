import java.util.*;

class Main {
	static class Student {
		String name;
		int a;
		int b;
		int c;

		public Student(String name, int a, int b, int c) {
			this.name = name;
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		Student[] students = new Student[n];

		for (int i = 0; i < n; i++) {
			students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(students, (o1, o2) -> {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;

			if (s1.a != s2.a) {
				return s2.a - s1.a;
			}
			if (s1.b != s2.b) {
				return s1.b - s2.b;
			}
			if (s1.c != s2.c) {
				return s2.c - s1.c;
			}

			return s1.name.compareTo(s2.name);
		});
		for (int i = 0; i < n; i++) {
			System.out.println(students[i].name);
		}
	}
}

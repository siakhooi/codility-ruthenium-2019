package nsh.codility;

import java.util.Arrays;

public class Ruthenium2019A implements Ruthenium2019Interface {

	class Node implements Comparable<Node> {
		int count = 0;
		int n = 0;

		public int compareTo(Node o) {
			return o.count - count; // sort descending
		}
	}

	public int solution(int[] A, int K) {
		int N = A.length;
		int last = 0;
		Node[] A1 = new Node[N + 2];
		Node[] A2 = new Node[100001];
		int a1 = 0;
		int a2l = 10000000, a2u = -1;

		// add dummy leading not
		A1[0] = new Node();
		A1[0].count = 0;
		A1[0].n = 0;
		for (int i = 0; i < N; i++) {
			int n = A[i];

			if (n == last)
				A1[a1].count++;
			else {
				last = n;
				A1[++a1] = new Node();
				A1[a1].count = 1;
				A1[a1].n = last;
			}
			if (A2[n] == null) {
				A2[n] = new Node();
				A2[n].n = n;
				A2[n].count = 1;
				a2l = Math.min(a2l, n);
				a2u = Math.max(a2u, n);
			} else
				A2[n].count++;
		}
		// add dummy trailing not
		A1[++a1] = new Node();
		A1[a1].count = 0;
		A1[a1++].n = 0;

		int nullcount = 0;
		for (int i = a2l; i <= a2u; i++)
			if (A2[i] == null) {
				A2[i] = new Node();
				nullcount++;
			}

		Arrays.sort(A2, a2l, a2u + 1);
		a2u -= nullcount;
		if (K == 0) {
			Arrays.sort(A1, 0, a1);
			return A1[0].count;
		}
		int R = 0;
		int r[] = new int[N];

		for (int i = a2l; i <= a2u && R < A2[i].count + K; i++) {
			int n = A2[i].n;
			int r0 = 0;// leading no
			int r1 = 0;// trailing no

			int j = 0;
			int total_no = 0;
			int total_yes = 0;
			r[r0] = 0;
			while (A1[j].n != n)
				r[r0] += A1[j++].count;
			total_no = r[0];

			while (j < a1 && r1 < a1) {
				r[++r1] = A1[j++].count;
				total_yes += r[r1];
				r[++r1] = 0;
				while (j < a1 && A1[j].n != n)
					r[r1] += A1[j++].count;
				total_no += r[r1];

				R = Math.max(R, total_yes + Math.min(K, total_no));

				if (r[r1] > K) {
					total_no = r[r1];
					total_yes = 0;
					r0 = r1;
				} else
					while (total_no - r[r0] > K) {
						total_no -= r[r0++];
						total_yes -= r[r0++];
					}
			}
		}

		return R;
	}
}

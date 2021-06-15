package nsh.codility;

import java.util.ArrayList;
import java.util.Arrays;

public class Ruthenium2019B implements Ruthenium2019Interface {

	class Node implements Comparable<Node> {
		int start = 0;
		int count = 0;
		int n = 0;
		ArrayList<Node> all = new ArrayList<Node>();
		int no_before = 0;

		public int compareTo(Node o) {
			return o.count - count; // sort descending
		}
	}

	public int solution(int[] A, int K) {
		int N = A.length;
		Node[] A1 = new Node[N];
		Node[] A2 = new Node[100001];
		int a1 = -1;
		int a2l = 10000000, a2u = -1;

		int last = 0;
		for (int i = 0; i < N; i++) {
			int n = A[i];

			if (A2[n] == null) {
				A2[n] = new Node();
				A2[n].n = n;
				A2[n].count = 1;
				a2l = Math.min(a2l, n);
				a2u = Math.max(a2u, n);
			} else {
				A2[n].count++;
			}

			if (n == last)
				A1[a1].count++;
			else {
				last = n;
				A1[++a1] = new Node();
				A1[a1].start = i;
				A1[a1].count = 1;
				A1[a1].n = last;
				if (A2[n].all.size() > 0) {
					Node nx = A2[n].all.get(A2[n].all.size() - 1);
					A1[a1].no_before = i - nx.start - nx.count;
				} else {
					A1[a1].no_before = i;
				}

				A2[n].all.add(A1[a1]);
			}
		}

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

		for (int i = a2l; i <= a2u && R < A2[i].count + K; i++) {
			Node n = A2[i];
			ArrayList<Node> all = n.all;
			int total_no = 0;
			int total_yes = 0;
			int r0 = 0;

			for (int j = 0; j < all.size(); j++) {
				Node n1 = all.get(j);
				total_no += n1.no_before;
				total_yes += n1.count;
				int end = n1.start + n1.count;

				R = Math.max(R, total_yes + Math.min(K, total_no + N - end));
				if (j < all.size() - 1) {
					Node nt = all.get(j + 1);
					if (nt.no_before > K) {
						total_no = 0;
						total_yes = 0;
						r0 = j + 1;
					} else {
						while (r0 < all.size() && total_no + nt.no_before - all.get(r0).no_before > K) {
							total_no -= all.get(r0).no_before;
							total_yes -= all.get(r0).count;
							r0++;
						}
					}
				}
			}
		}

		return R;
	}
}

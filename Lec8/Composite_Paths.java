package Lec8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Composite_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>> adjlist = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjlist.add(i, new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjlist.get(a).add(b);
			adjlist.get(b).add(a);
		}
		IsPrime(n);
		DFS(adjlist, 1, -1);

		System.out.println(ans);

	}

	private static Pair DFS(List<List<Integer>> adjlist, int node, int parent) {
		// TODO Auto-generated method stub
		List<Pair> ll = new ArrayList<>();
		for (int nbrs : adjlist.get(node)) {// 2 , 6
			// System.out.println(nbrs);
			if (nbrs != parent) {

				ll.add(DFS(adjlist, nbrs, node));
				// System.out.println(ll);
			}
		}

		if (prime[node] == false) {// node is prime
			int totalnonprimepath = 0;
			for (Pair child : ll) {
				ans += totalnonprimepath * child.nonprimepath;
				totalnonprimepath += child.nonprimepath;
			}
			ans += totalnonprimepath;
			Pair p = new Pair();
			p.nonprimepath = 0;
			p.oneprimepath = 1 + totalnonprimepath;
			return p;

		} else {
			int totalnonprimepath = 0;
			int totaloneprimepath = 0;
			for (Pair child : ll) {
				ans += child.nonprimepath * totaloneprimepath;
				ans += child.oneprimepath * totalnonprimepath;
				totalnonprimepath += child.nonprimepath;
				totaloneprimepath += child.oneprimepath;
			}
			ans += totaloneprimepath;
			Pair p = new Pair();
			p.nonprimepath = totalnonprimepath + 1;
			p.oneprimepath = totaloneprimepath;
			return p;

		}

	}

	static long ans = 0;
	static boolean[] prime;

	public static void IsPrime(int n) {
		prime = new boolean[n + 1];
		// false wala index prime number and true wala index not prime
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= n; i++) {
			if (prime[i] == false) {
				for (int j = 2; i * j < prime.length; j++) {
					prime[i * j] = true;
				}
			}
		}
	}

	static class Pair {
		long nonprimepath = 0;
		long oneprimepath = 0;
	}

}

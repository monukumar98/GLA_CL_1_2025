package Lec6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GCDecomposition2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			set.add(x);
		}
		if (n < 2) {
			System.out.println("no");
			return;
		}
		List<Integer> num = new ArrayList<>(set);
		// build graph if GCD(a,b) is 1 ==> a---b
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < num.size(); i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < num.size(); i++) {
			for (int j = i + 1; j < num.size(); j++) {
				int a = num.get(i);
				int b = num.get(j);
				if (GCD(a, b) == 1) {
					adj.get(i).add(j);
					adj.get(j).add(i);
				}
			}
		}
		if (isBipartite(adj)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

	}

	public static boolean isBipartite(List<List<Integer>> adj) {
		// TODO Auto-generated method stub
		int[] color = new int[adj.size()];// 0 ka mtlb color nhi kra hai
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < adj.size(); i++) {
			if (color[i] == 0) {
				color[i] = 1;
				q.add(i);
				while (!q.isEmpty()) {
					int node = q.poll();
					for (int nbrs : adj.get(node)) {
						if (color[nbrs] == 0) {
							// color krna hai
							color[nbrs] = 3 - color[node];
							q.add(nbrs);
						} else if (color[nbrs] == color[node]) {
							return false;
						}
					}

				}
			}

		}
		return true;
	}

	public static int GCD(int a, int b) {
		while (a % b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}
		return b;
	}
}

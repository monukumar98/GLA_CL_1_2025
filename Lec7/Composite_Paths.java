package Lec7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Composite_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 1; i <= n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

	}

}

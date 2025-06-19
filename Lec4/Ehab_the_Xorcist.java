package Lec4;

public class Ehab_the_Xorcist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int u = 1;// xor
		int v = 3;// sum
		if (u > v || (u % 2 != v % 2)) {
			System.out.println(-1);
			return;
		}
		if (u == v) {
			if (u == 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
				System.err.println(u);
			}
			return;
		}
		int x = (v - u) / 2;
		if ((u & x) == 0) {
			System.out.println(2);
			System.out.println(u + x + " " + x);
		} else {
			System.out.println(3);
			System.out.println(u + " " + x + " " + x);
		}

	}

}

package Lec4;

import java.util.Scanner;

public class Preparing_Olympiad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int x = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}

	}

	public static int Preparing(int[] c, int l, int r, int x) {
		int n = c.length;
		int ans = 0;
		for (int i = 3; i < (1 << n); i++) {
			if (FastCountBit(i) >= 2 && isvalid(c, l, r, x, i)) {
				ans++;
			}
		}
		return ans;

	}

	private static boolean isvalid(int[] c, int l, int r, int x, int i) {
		// TODO Auto-generated method stub
		int pos = 0;// c ke index ke liye
		int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while (i > 0) {
			if ((i & 1) != 0) {
				sum += c[pos];
				min = Math.min(min, c[pos]);
				max = Math.min(max, c[pos]);
			}
			pos++;
			i >>= 1;
		}
		return sum>=l && sum<=r && max-min>=x;
	}

	public static int FastCountBit(int n) {
		int c = 0;
		while (n > 0) {
			c++;
			n = (n & (n - 1));
		}
		return c;
	}
}

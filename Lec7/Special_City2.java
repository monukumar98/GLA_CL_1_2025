package Lec7;

import java.util.Scanner;

public class Special_City2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] dis = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i > x) {
				int mn = 1;
				int mx = n - i;
				dis[mn]++;
				dis[mx + 1]--;
			} else {
				int mn = 1;
				int mx = y - i - 1;
				dis[mn]++;
				dis[mx + 1]--;
				mn = (y - i) - (y - x - 1);
				mx = (n - i) - (y - x - 1);
				dis[mn]++;
				dis[mx + 1]--;
			}
		}
		for (int i = 1; i <= n; i++) {
			dis[i] += dis[i - 1];
		}
		for (int i = 1; i < n; i++) {
			System.out.print(dis[i] + " ");
		}
	}

}

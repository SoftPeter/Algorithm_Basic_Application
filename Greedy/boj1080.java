package Greedy;

import java.util.*;

public class boj1080 {
	private static void flip(int a[][], int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				a[i][j] = 1 - a[i][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m];
		int b[][] = new int[n][m];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = line.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = line.charAt(j) - '0';
			}
		}

		int ans = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				if (a[i][j] != b[i][j]) {
					ans++;
					flip(a, i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != b[i][j]) {
					System.out.println("-1");
					System.exit(0);
				}
			}
		}
		System.out.println(ans);

	}
}

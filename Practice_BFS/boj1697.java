package Practice_BFS;

import java.util.*;

public class boj1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[100005];
		Arrays.fill(a, -1);
		System.out.println(bfs(n, k, a));
	}
	
	private static int bfs(int n, int k, int[] a) {
		Queue<Integer> q = new LinkedList<>();
		int nextn = n;
		q.add(nextn);
		a[nextn] = 0;
		int status[] = new int[3];
		while(!q.isEmpty() && nextn != k) {
			nextn = q.remove();
			status[0] = nextn +1;
			status[1] = nextn -1;
			status[2] = nextn *2;
			
			for(int i=0; i<3; i++) {
				if(status[i] >= 0 && status[i] <= 100000) {
					if(a[status[i]] == -1) {
						a[status[i]] = a[nextn] + 1;
						q.add(status[i]);
					}
				}
			}
		}
		return a[k];
	}
}

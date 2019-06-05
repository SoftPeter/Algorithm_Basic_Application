package Easy_Tree;

import java.util.*;

class line {
	int parent;
	int child;
	line(int parent, int child){
		this.parent = parent;
		this.child = child;
	}
}

public class boj1967 {
	public static int[] bfs(int n, List<line>a[], int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean c[] = new boolean[n+1];
		int dist[] = new int[n+1];
		q.add(start);
		c[start] = true;
		while(!q.isEmpty()) {
			int x = q.remove();
			for(line e : a[x]) {
				int to = e.parent;
				int cost = e.child;
				if(c[to] == false) {
					c[to] = true;
					dist[to] = dist[x] + cost;
					q.add(to);
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<line> a[] = (List<line>[]) new List[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			a[x].add(new line(y, z));
			a[y].add(new line(x, z));
		}
		
		int dist[] = bfs(n, a, 1);
		
		int start = 1;
		for(int i=2; i<=n; i++) {
			if(dist[start] < dist[i])
				start = i;
		}
		
		dist = bfs(n, a, start);
		
		int ans=dist[1];
		for(int i=2; i<=n; i++) {
			if(ans < dist[i])
				ans = dist[i];
		}
		System.out.println(ans);
	}
}
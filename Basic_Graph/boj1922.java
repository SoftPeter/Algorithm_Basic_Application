package Basic_Graph;

import java.util.*;

class Node implements Comparable<Node>{
	int n1;
	int n2;
	int cost;
	Node(int n1, int n2, int cost){
		this.n1 = n1;
		this.n2 = n2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		if(this.cost < o.cost)
			return -1;
		else if(this.cost == o.cost)
			return 0;
		else
			return 1;
	}
}

public class boj1922{
	public static int[] parent;
	public static ArrayList<Node> nodeList;
	public static int ans;
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y)
			parent[y] = x;
	}
	public static int find(int x) {
		if(x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		nodeList = new ArrayList<Node>();
		for(int i=0; i<m; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int cost = sc.nextInt();
			nodeList.add(new Node(n1, n2, cost));
		}
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		Collections.sort(nodeList);
		
		ans = 0;
		for(int i=0; i<nodeList.size(); i++) {
			Node node = nodeList.get(i);
			if(!isSameParent(node.n1, node.n2)) {
				union(node.n1, node.n2);
				ans += node.cost;
			}
		}
		System.out.println(ans);
	}
}

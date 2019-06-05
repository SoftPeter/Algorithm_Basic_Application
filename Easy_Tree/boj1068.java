package Easy_Tree;

import java.util.*;

public class boj1068 {
	static int[][] nodes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nodes = new int[n][2];
		
		for(int i=0; i<n; i++) {
			nodes[i][0] = sc.nextInt();
		}
		
		setNode(n);
		
		removeNode(sc.nextInt());
		
		System.out.println(getLeafNode());
		sc.close();
	}
	private static void setNode(int n) {
		// TODO Auto-generated method stub
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(nodes[j][0] == i)
					nodes[i][1] += 1;
			}
		}
	}
	private static void removeNode(int startNode) {
		// TODO Auto-generated method stub
		if(nodes[startNode][0] != -1)
			nodes[nodes[startNode][0]][1]--;
		
		nodes[startNode][0] = -2;
		
		if(nodes[startNode][1] != 0) {
			for(int i=0; i<nodes.length; i++) {
				if(nodes[i][0] == startNode)
					removeNode(i);
			}
		}
	}
	private static int getLeafNode() {
		// TODO Auto-generated method stub
		int leafNode = 0;
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i][0] != -2 && nodes[i][1] == 0)
				leafNode++;
		}
		return leafNode;
	}
}
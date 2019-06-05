package Easy_Tree;

import java.util.*;

class Node{
	int parent;
	int num;
	int left;
	int right;
	Node(int num, int left, int right){
		this.parent = -1;
		this.num = num;
		this.left = left;
		this.right = right;
	}
}

public class boj2250 {
	static Scanner sc = new Scanner(System.in);
	static int point = 1;
	static List<Node> tree = new ArrayList<>();
	static int[] levelMin;
	static int[] levelMax;
	static int maxLevel = 0;
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		levelMin = new int[n+1];
		levelMax = new int[n+1];
		int rootIndex = 0;
		for(int i=0; i<=n; i++) {
			tree.add(new Node(i, -1, -1));
			levelMin[i] = n;
			levelMax[i] = 0;
		}
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			int left = sc.nextInt();
			int right = sc.nextInt();
			tree.get(num).left = left;
			tree.get(num).right = right;
			if(left != -1)
				tree.get(left).parent = num;
			if(right != -1)
				tree.get(right).parent = num;
		}
		for(int i=1; i<=n; i++) {
			if(tree.get(i).parent == -1) {
				rootIndex = i;
				break;
			}
		}
		
		inOrder(rootIndex, 1);
		
		int answerLevel = 1;
		int answerWidth = levelMax[1] - levelMin[1] + 1;
		for(int i=2; i<=maxLevel; i++) {
			int width = levelMax[i] - levelMin[i] + 1;
			if(answerWidth < width) {
				answerLevel = i;
				answerWidth = width;
			}
		}
		System.out.println(answerLevel + " " + answerWidth);
	}

	private static void inOrder(int rootIndex, int level) {
		Node root = tree.get(rootIndex);
		if(maxLevel < level)
			maxLevel = level;
		if(root.left != -1)
			inOrder(root.left, level+1);
		levelMin[level] = Math.min(levelMin[level], point);
		levelMax[level] = point;
		point++;
		if(root.right != -1)
			inOrder(root.right, level+1);
		
	}
}

package Real_Easy_Problem;

import java.io.*;
import java.util.*;

public class boj1032 {
	public static void main(String[] args) throws IOException{
		//Scanner sc = new Scanner(System.in);
		//int t = sc.nextInt();
		//sc.nextLine();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String input[] = new String[t];
		boolean c = true;
		String str = "";
		for(int i=0; i<t; i++) {
			input[i] = br.readLine();
		}
		
		for(int i=0; i<input[0].length(); i++) {
			for(int j=1; j<t; j++) {
				if(input[0].charAt(i) == input[j].charAt(i)) {
					c = true;
				} else {
					c = false;
					break;
				}
			}
			if(c==true) {
				str += input[0].charAt(i);
			} else {
				str += "?";
			}
		}
		System.out.println(str);
	}
}

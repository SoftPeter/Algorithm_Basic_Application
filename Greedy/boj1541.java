package Greedy;

import java.io.*;

public class boj1541 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split("\\-");
		int ans=0;
		for(int i=0; i<input.length; i++) {
			int sum = calc(input[i]);
			
			if(i==0)
				sum *= -1;
			ans -= sum;
		}
		System.out.println(ans);
	}
	
	private static int calc(String str) {
		String num[] = str.split("\\+");
		int result=0;
		for(String item : num) {
			result += Integer.parseInt(item);
		}
		return result;
	}
}

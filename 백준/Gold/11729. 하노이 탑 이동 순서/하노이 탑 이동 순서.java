import java.util.Scanner;
public class Main {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		System.out.println((int)(Math.pow(2, N))-1);
		hanoi(N);
		System.out.println(sb.toString());
	}
	private static void hanoi(int n) {
		hanoi(n,1,2,3);
	}
	private static void hanoi(int n, int a, int b, int c) {
		if(n==1) {
			sb.append(a+" "+c+"\n");
			return ;
		}
		hanoi(n-1, a, c, b);
		sb.append(a+" "+c+"\n");
		hanoi(n-1, b, a, c);
	}
}

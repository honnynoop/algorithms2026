import java.util.Scanner;

public class Main {
	
	static int [][] chess;
	static int N=6;
	static int M=2;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		chess=new int[M][N];
		chess[0]=new int[] {1,1,2,2,2,8};
		for (int i = 0; i < N; i++) {
			chess[1][i]=scann.nextInt();
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(chess[0][i]-chess[1][i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
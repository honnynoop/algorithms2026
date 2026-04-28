import java.util.Scanner;

public class Main {
	static int K;
	static int X,Y;
	static int num;
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		K=scann.nextInt();
		X=scann.nextInt()-1;
		Y=scann.nextInt()-1;
		// 모두 구한 후 위아래 뒤집기
		N=1<<K;
		map=new int[N][N];
		map[Y][X]=-1;
		
		go(N,0,0);
		
		for (int i = N-1; i >=0; i--) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
	}
	private static void go(int n, int r, int c) {
		num++;
		int s=n/2;
		if(check(s,r,c))map[r+s-1][c+s-1]=num;
		if(check(s,r+s,c))map[r+s][c+s-1]=num;
		if(check(s,r,c+s))map[r+s-1][c+s]=num;
		if(check(s,r+s,c+s))map[r+s][c+s]=num;
		if(n==2) return ;
		go(s,r,c);
		go(s,r+s,c);
		go(s,r,c+s);
		go(s,r+s,c+s);
	}
	private static boolean check(int s, int r, int c) {
		for (int i = r; i < r+s; i++) {
			for (int j = c; j < c+s; j++) {
				if(map[i][j]!=0) return false;
			}
		}
		return true;
	}
	
}